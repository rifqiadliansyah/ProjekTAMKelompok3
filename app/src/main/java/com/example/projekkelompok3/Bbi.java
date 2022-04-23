package com.example.projekkelompok3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class Bbi extends AppCompatActivity {
    EditText namalengkap;
    EditText tinggibadan;
    EditText bbi;
    Button button1;
    private RadioButton pria, wanita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_bbi);
        namalengkap=findViewById(R.id.namalengkap);
        pria=findViewById(R.id.pria);
        wanita=findViewById(R.id.wanita);
        tinggibadan=findViewById(R.id.tinggibadan);
        bbi=findViewById(R.id.bbi);
        Button proses = findViewById(R.id.button1);
        proses.setOnClickListener(this::onClick);
    }
    private void onClick(View v) {
        double bbi2 = 0;
        String stringTinggiBadan = tinggibadan.getText().toString();
        double tinggibadan = Double.parseDouble(stringTinggiBadan);
        if (pria.isChecked()) {
            bbi2 = (tinggibadan - 100) * 0.9;
        }
        if (wanita.isChecked()) {
            bbi2 = (tinggibadan - 100) * 0.85;
        }
        String bbi3=String.valueOf(bbi2); bbi.setText(bbi3+"");
    }
}