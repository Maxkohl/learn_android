package com.example.powerreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

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


    }

    @Override
    protected void onDestroy() {
        this.unregisterReceiver(mReceiver);
        super.onDestroy();
    }
}