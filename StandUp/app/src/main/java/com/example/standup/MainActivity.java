package com.example.standup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationManager;
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

        mNotifyManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
    }
}