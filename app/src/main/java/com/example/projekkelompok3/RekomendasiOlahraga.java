package com.example.projekkelompok3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class RekomendasiOlahraga extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_rekomendasi_olahraga);
    }
}