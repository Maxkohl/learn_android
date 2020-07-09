package com.example.notifyme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.MediaSession2Service;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";
    private static final int NOTIFICATION_ID = 0;
    private NotificationManager mNotifyManager;

    private Button button_notify;
    private Button button_update;
    private Button button_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_notify = findViewById(R.id.notify);
        button_notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendNotification();
            }
        });
        button_update = findViewById(R.id.update);
        button_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateNotification();
            }
        });
        button_cancel = findViewById(R.id.cancel);
        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelNotification();
            }
        });

        //Create channel in onCreate or app crashes!
        createNotificationChannel();
    }

    private void cancelNotification() {
        mNotifyManager.cancel(NOTIFICATION_ID);
    }

    private void updateNotification() {
        //Convert image to BitMap
        Bitmap androidImage = BitmapFactory.decodeResource(getResources(), R.drawable.mascot_1);
        NotificationCompat.Builder notifyBuilder = getNotificationBuilder();
        //Change style by setting it again
        notifyBuilder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(androidImage).setBigContentTitle("Notification updated!"));
        mNotifyManager.notify(NOTIFICATION_ID, notifyBuilder.build());
    }

    public void createNotificationChannel() {
        //Create Notification Manager
        mNotifyManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
            //Create notification channel
            NotificationChannel notificationChannel = new NotificationChannel(PRIMARY_CHANNEL_ID,
                    "Mascot Notification", NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription("Notification from Mascot");
            mNotifyManager.createNotificationChannel(notificationChannel);
        }
    }

    private void sendNotification() {
        //Use getNotificationBuilder to create builder in method
        NotificationCompat.Builder notifyBuilder = getNotificationBuilder();
        //Use manager to notify (send notification) with the ID and the builder method
        mNotifyManager.notify(NOTIFICATION_ID, notifyBuilder.build());

    }

    //Helper class that builds Notification Builder for you
    private NotificationCompat.Builder getNotificationBuilder() {
        //Create intent to be used when user clicks notification action
        Intent intent = new Intent(this, MainActivity.class);
        //Wrap that intent in a PendingIntent
        PendingIntent notifyPendingIntent = PendingIntent.getActivity(this, NOTIFICATION_ID,
                intent, PendingIntent.FLAG_UPDATE_CURRENT);


        NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(this,
                PRIMARY_CHANNEL_ID);
        notifyBuilder.setContentTitle("You have been notified!").setContentText("This is your " +
                "notification text.").setSmallIcon(R.drawable.ic_android);

        //Set PendingIntent on action in notification builder
        notifyBuilder.setContentIntent(notifyPendingIntent).setAutoCancel(true);

        //For backwards compatibility, set priorty and defaults
        notifyBuilder.setPriority(NotificationCompat.PRIORITY_HIGH).setDefaults(NotificationCompat.DEFAULT_ALL);

        return notifyBuilder;
    }
}