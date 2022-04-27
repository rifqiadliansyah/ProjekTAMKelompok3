package com.example.projekkelompok3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.projekkelompok3.bottomNavPKG.HomePage;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
            Intent i = new Intent(MainActivity.this, HomePage.class);
            startActivity(i);
            finish();
            }
        },1500);

    }
}