package com.example.projekkelompok3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projekkelompok3.MakananSehatPKG.MineralReminder;

import java.util.ArrayList;

public class HitungMineral extends AppCompatActivity  {
    private EditText bbpengguna, kadar;
    private TextView hasilmineral;
    private Button hitung , notif;


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
        notif = (Button) findViewById(R.id.btn_notif);
        buatNotifikasiChannel();



        notif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HitungMineral.this, "Berhasil Setel pengingat", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(HitungMineral.this, MineralReminder.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(HitungMineral.this,100,
                        intent,PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

                long timeAtButtonClick = System.currentTimeMillis();
                long time  = 900000;
                alarmManager.set(AlarmManager.RTC_WAKEUP,timeAtButtonClick+time,
                        pendingIntent);
            }
        });

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

    public void buatNotifikasiChannel(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            CharSequence nama = "ChannelNotifikasi";
            String deskripsi = "ChannelReminder";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("notifikasiid",nama,importance);
            channel.setDescription(deskripsi);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }


}
