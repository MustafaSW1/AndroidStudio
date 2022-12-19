package com.example.services_forgraund1;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.core.app.NotificationCompat;

public class MyService extends Service {

    public static final String CHANNAL_ID = "x_channelId";
    NotificationChannel channel;
    MediaPlayer mp;
    public MyService() {
    }


    @Override
    public void onCreate() {
        super.onCreate();
        mp = MediaPlayer.create(this,R.raw.sound);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                stopSelf();
            }
        });
        Log.d("jjjjjj","created");
    }

    @Override
    public void onDestroy() {
        if (mp.isPlaying()){
            mp.stop();
            mp.release();
        }

        Log.d("jjjjjj","destroyed");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startForeground(1,getNotificationObject());
        if (!mp.isPlaying()){
            mp.start();
        }
        Log.d("jjjjjj","started");
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
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