package com.example.mynotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private NotificationManager manager;
    private Notification notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel("jia", "测试通知", NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(notificationChannel);
        }
        Intent intent = new Intent(this, NotificationActivity.class);
        PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 0);
        notification = new NotificationCompat.Builder(this, "jia")
                .setContentTitle("官方通知")
                .setContentText("世界那么大，想去走走")
                .setSmallIcon(R.drawable.ic_baseline_person_24)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.scene))
                .setColor(Color.parseColor("#ff0000"))
                .setContentIntent(activity)
                .setAutoCancel(true)
                .build();
    }

    public void sendNotification(View view) {
        manager.notify(1,notification);
    }

    public void cancelNotification(View view) {
        manager.cancel(1);
    }
}