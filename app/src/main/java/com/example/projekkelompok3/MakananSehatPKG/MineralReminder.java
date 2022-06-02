package com.example.projekkelompok3.MakananSehatPKG;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.projekkelompok3.R;

public class MineralReminder extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,"notifikasiid")
                .setSmallIcon(R.drawable.ic_aer)
                .setContentTitle("Pengingat Minum air")
                .setContentText("Ingat sayangi ginjalmu, minumlah air yang cukup")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

        notificationManager.notify(100,builder.build());
    }
}
