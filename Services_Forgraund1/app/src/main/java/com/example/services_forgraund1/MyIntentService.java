package com.example.services_forgraund1;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;


public class MyIntentService extends IntentService {


    public static final String CHANNAL_ID = "x_channelId";
    NotificationChannel channel;

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Log.d("jjjjjjj","started");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("jjjjjj","created");
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("jjjjjjj","Destroyed");
    }


    private Notification getNotificationObject() {
        if (Build.VERSION.SDK_INT >= 26){

            channel = new NotificationChannel(CHANNAL_ID,"channel", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("My Notification Channel");
        }

        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this,0,intent,0);


        NotificationManager nm = getSystemService(NotificationManager.class);
        nm.createNotificationChannel(channel);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getBaseContext(),CHANNAL_ID);
        builder.setSmallIcon(R.drawable.ic_launcher_foreground);
        builder.setContentTitle("Title");
        builder.setContentText("Content Text");
        builder.setContentIntent(pi);
        builder.setPriority(NotificationCompat.PRIORITY_HIGH);
        builder.setStyle(new NotificationCompat.BigTextStyle().bigText("Big text"));
        builder.addAction(R.drawable.ic_launcher_background,"Replay",pi);
/*
        NotificationManagerCompat nmc = NotificationManagerCompat.from(this);
        nmc.notify(10,builder.build());
 */
        return builder.build();

    }


}