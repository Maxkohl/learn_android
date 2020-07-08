package com.example.powerreceiver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    //Unique ID from custom broadcast
    private static final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";

    //Create Custom dynamic receiver
    private CustomReceiver mReceiver = new CustomReceiver();
    //Create intent filter with intent actions
    IntentFilter filter = new IntentFilter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Add Intent actions to the intent filter
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        //Register the receiver using activity context. Make sure to UNREGISTER in onDestroy
        this.registerReceiver(mReceiver, filter);

        //Register receiver for LocalBroadcastManager
        LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver,
                new IntentFilter(ACTION_CUSTOM_BROADCAST));


    }

    @Override
    protected void onDestroy() {
        this.unregisterReceiver(mReceiver);

        //Unregister receiver for Local Broadcast
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mReceiver);
        super.onDestroy();
    }

    public void sendCustomBroadcast(View view) {
        //Create new intent with custom action string as an argument
        Intent intent = new Intent(ACTION_CUSTOM_BROADCAST);
        //Send local broadcast using LocalBroadcastManager
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);

    }
}