package com.example.projekkelompok3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public abstract class HitungMineral extends AppCompatActivity implements View.OnClickListener {
    private EditText bbpengguna, kadar;
    private TextView hasilmineral;
    private Button hitung;

    static double hitungMineral(double weight){
        double jumlah = 0;
        ArrayList<Double> total = new ArrayList<Double>();
        weight-=10;
        total.add(1000.0);

        if(weight>10){
            weight -= 10;
            total.add(500.0);
            double sisa = weight*20;
            total.add(sisa);
        }else{
            total.add(1000.0);
        }

        for(double x:total){
            jumlah+=x;
        }
        return jumlah;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_hitung_mineral);
    bbpengguna = (EditText) findViewById(R.id.jumlahbbmineral);
    kadar = (EditText) findViewById(R.id.kadar);
    hasilmineral = (TextView) findViewById(R.id.hasilmineral);
    hitung = (Button) findViewById(R.id.btnhitung);
    hitung.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.btnhitung) {
                String BeratBadan = bbpengguna.getText().toString().trim();
                String Kadar = kadar.getText().toString().trim();
                boolean isEmptyFields = false;
                if (TextUtils.isEmpty(BeratBadan)) {
                    isEmptyFields = true;
                    bbpengguna.setError("Field ini tidak boleh kosong");
                }
                if (TextUtils.isEmpty(Kadar)) {
                    isEmptyFields = true;
                    bbpengguna.setError("Field ini tidak boleh kosong");
                }
                if (!isEmptyFields) {
                    double b = Double.parseDouble(BeratBadan);
                    double k = Double.parseDouble(Kadar);

                    //
                    }
            }
        }
    });
    }
}
