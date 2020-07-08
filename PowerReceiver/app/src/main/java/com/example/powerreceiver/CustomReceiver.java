package com.example.powerreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {
    //Unique ID from custom broadcast
    private static final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        //Get intent action of received broadcast
        String intentAction = intent.getAction();

        //Check to see if intentAction isn't null
        if (intentAction != null) {
            String toastMessage = "Uknown intent action";
            //Switch statement of what to do with action
            switch (intentAction) {
                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage = "Power is CONNECTED!";
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage = "Power is DISCONNECTED!";
                    break;
            }
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
        }
    }
}
