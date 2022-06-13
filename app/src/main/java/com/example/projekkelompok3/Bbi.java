package com.example.projekkelompok3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Bbi extends AppCompatActivity {

    EditText tinggiBadan;
    TextView bbi, historiTinggi;
    private RadioButton pria, wanita;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_bbi);
        NumberFormat formatter = new DecimalFormat("#0.00");
        pria=findViewById(R.id.pria);
        wanita=findViewById(R.id.wanita);
        tinggiBadan=findViewById(R.id.tinggibadan);
        bbi=findViewById(R.id.bbi);
        historiTinggi = findViewById(R.id.tv_tinggiHistori);

        SharedPreferences sharedPref;
        sharedPref = getSharedPreferences("sp_tinggi",MODE_PRIVATE);


        Button proses = findViewById(R.id.button1);
        Button histori = findViewById(R.id.btn_histori);


        proses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double bbi2 = 0;
                String stringTinggiBadan = tinggiBadan.getText().toString();

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("DATA",stringTinggiBadan);
                editor.apply();

                double tinggibadan = Double.parseDouble(stringTinggiBadan);

                if(TextUtils.isEmpty(stringTinggiBadan)){
                    tinggiBadan.setError("Field Tidak Boleh Kosong");
                }
                if (pria.isChecked()) {
                    bbi2 = (tinggibadan - 100) * 0.9;
                }
                if (wanita.isChecked()) {
                    bbi2 = (tinggibadan - 100) * 0.85;
                }
                bbi.setText(formatter.format(bbi2));
            }
        });

        histori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dataHistoriTinggi = sharedPref.getString("DATA","");
                historiTinggi.setVisibility(View.VISIBLE);
                historiTinggi.setText("Tinggi sebelumnya adalah : "+dataHistoriTinggi+"cm");
            }
        });

    }


    }





