package com.example.zad8;

import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {
    private MyService odometer;
    private boolean bound = false;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder binder) {
            MyService.OdometerBinder odometerBinder =
                    (MyService.OdometerBinder) binder;
            odometer = odometerBinder.getOdometer();
            bound = true;
        }
        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            bound = false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        watchMileage();
    }
    public void onClick(View view) {
        Intent intent = new Intent(this, MyIntentService.class);
        intent.putExtra(MyIntentService.EXTRA_MESSAGE,
                getResources().getString(R.string.button_response));
        startService(intent);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, MyService.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }
    @Override
    protected void onStop() {
        super.onStop();
        if (bound) {
            unbindService(connection);
            bound = false;
        }
    }
    private void watchMileage() {
        final TextView distanceView = (TextView)findViewById(R.id.distance);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                double distance = 0.0;
                if (odometer != null) {
                    distance = odometer.getDistance();
                }
                String distanceStr = String.format("%1$,.2f kilometra", distance);
                distanceView.setText(distanceStr);
                handler.postDelayed(this, 1000);
            }
        });
    }
}
