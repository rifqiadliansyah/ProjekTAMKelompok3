package com.example.projekkelompok3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Bbi extends AppCompatActivity {

    EditText tinggiBadan;
    TextView bbi;
    private RadioButton pria, wanita;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_bbi);
        pria=findViewById(R.id.pria);
        wanita=findViewById(R.id.wanita);
        tinggiBadan=findViewById(R.id.tinggibadan);
        bbi=findViewById(R.id.bbi);
        Button proses = findViewById(R.id.button1);
        proses.setOnClickListener(this::onClick);

    }
    private void onClick(View v) {

        if(v.getId()==R.id.button1) {

        double bbi2 = 0;
        String stringTinggiBadan = tinggiBadan.getText().toString();
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
        String bbi3=String.valueOf(bbi2);
        bbi.setText(bbi3+"");
    }

    }





}