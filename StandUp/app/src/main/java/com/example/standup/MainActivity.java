package com.example.standup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private NotificationManager mNotifyManager;

    private final static int NOTIFICATION_ID = 0;
    private final static String NOTIFICATION_CHANNEL_ID = "primary_notification_channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToggleButton alarmToggle = findViewById(R.id.alarmToggle);
        alarmToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                String toastMessage;
                if (isChecked) {
                    toastMessage = getString(R.string.alarm_set_toast);
                } else {
                    toastMessage = getString(R.string.alarm_disabled_toast);
                }
                Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_SHORT).show();
            }
        });

        mNotifyManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
            NotificationChannel notifyChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID,
                    "Stand Up Notification", NotificationManager.IMPORTANCE_HIGH);
            notifyChannel.enableLights(true);
            notifyChannel.setLightColor(Color.RED);
            notifyChannel.enableVibration(true);
            notifyChannel.setDescription("Notifies every 15 minutes to stand up and walk around.");
            mNotifyManager.createNotificationChannel(notifyChannel);

        }
    }

    public void deliverNotification(Context context) {
        Intent contentIntent = new Intent(context, MainActivity.class);
        PendingIntent contentPendingIntent = PendingIntent.getActivity(context, NOTIFICATION_ID,
                contentIntent, PendingIntent.FLAG_UPDATE_CURRENT
        );
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,
                NOTIFICATION_CHANNEL_ID).setSmallIcon(R.drawable.ic_standup).setContentTitle(
                getString(R.string.standup_alert_title)).setContentText(getString(R.string.standup_alert_message)).setContentIntent(contentPendingIntent).setPriority(NotificationCompat.PRIORITY_HIGH).setDefaults(NotificationCompat.DEFAULT_ALL).setAutoCancel(true);
    }
}