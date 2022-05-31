package com.example.projekkelompok3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class HitungMineral extends AppCompatActivity  {
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
                String BeratBadan = bbpengguna.getText().toString().trim();
                String Kadar = kadar.getText().toString().trim();

                if (TextUtils.isEmpty(BeratBadan)) {
                    bbpengguna.setError("Field ini tidak boleh kosong");
                }
                else if (TextUtils.isEmpty(Kadar)) {
                    kadar.setError("Field ini tidak boleh kosong");
                }
                else{
                    double b = Double.parseDouble(BeratBadan);
                    double k = Double.parseDouble(Kadar);
                    if(b<10){
                        hasilmineral.setText("Berat badan harus >= 10 kg");
                    }else{
                        double hasilPerhitungan = hitungMineral(b);
                        System.out.println(hasilPerhitungan +"dan kadar :"+k);
                        if(hasilPerhitungan<= k ){
                            hasilmineral.setText("Kadar minum anda sudah cukup, yaitu minimal "+hasilPerhitungan+" ml");
                        }
                        if(hasilPerhitungan>k){
                            hasilmineral.setText("Kadar minum kurang, yaitu minimal "+hasilPerhitungan+" ml");
                        }
                    }

                    }

        }
    });
    }


}
