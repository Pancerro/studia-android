package com.example.zad8;

import android.app.IntentService;
import android.app.Notification;
import android.content.Intent;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MyIntentService extends IntentService {
    public static final String EXTRA_MESSAGE = "message";
    public static final int NOTIFICATION_ID = 5453;

    public MyIntentService() {
        super("MyIntentService");
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        synchronized (this) {
            try {
                wait(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String text = intent.getStringExtra(EXTRA_MESSAGE);
        showText(text);
    }
    private void showText(final String text) {
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        Log.v("DelayedMessageService", "To jest komunikat.");
    Notification notification = new NotificationCompat.Builder(this)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("xDxD")
            .setContentText("xddd")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
            .build();

    NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
         notificationManager.notify(NOTIFICATION_ID, notification);
 System.out.println(notificationManager);
}
}
