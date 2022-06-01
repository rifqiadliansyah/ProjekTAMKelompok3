package com.example.projekkelompok3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import pl.droidsonroids.gif.GifImageView;

public class RekomendasiOlahraga extends AppCompatActivity {
    private Chronometer chronometer;
    private TextView tvSelesai;
    private GifImageView giv;
    private Button btnStart,btnPause,btnBack ;
    private long pauseOffset;
    private boolean running;
    private int position = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_rekomendasi_olahraga);
        chronometer = findViewById(R.id.chronometer);
        btnStart = findViewById(R.id.btn_start);
        tvSelesai = findViewById(R.id.tv_selesai);
        btnPause = findViewById(R.id.btn_pause);
        btnBack = findViewById(R.id.btn_back);
        giv = findViewById(R.id.gif);
        chronometer.setFormat("Waktu : %s");
        chronometer.setBase(SystemClock.elapsedRealtime());

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {

                if((SystemClock.elapsedRealtime()-chronometer.getBase())>=30000){
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    if(position==3){
                        tvSelesai.setVisibility(View.VISIBLE);
                        btnBack.setVisibility(View.VISIBLE);
                        chronometer.stop();
                        btnStart.setVisibility(View.INVISIBLE);
                        btnPause.setVisibility(View.INVISIBLE);
                    }
                    else{
                    int[] gif = {R.drawable.orkursi,R.drawable.peregangan,R.drawable.skotjam,
                            R.drawable.stretch};
                    giv.setImageResource(gif[position]);
                    position++;
                    Toast.makeText(RekomendasiOlahraga.this,"Ayo Semangat", Toast.LENGTH_SHORT).show();}
                }
            }
        });
    }

    public void startChronometer(View view) {
        if(!running){
            chronometer.setBase(SystemClock.elapsedRealtime()-pauseOffset);
            chronometer.start();
            running = true;
        }
    }

    public void pauseChronometer(View view) {
        if(running){
            chronometer.stop();
            pauseOffset = SystemClock.elapsedRealtime()-chronometer.getBase();
            running = false;
        }
    }
}