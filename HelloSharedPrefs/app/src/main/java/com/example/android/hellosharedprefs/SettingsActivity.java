package com.example.android.hellosharedprefs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    private int mColor;
    // Text view to display both count and color
    private final String COLOR_KEY = "color";
    private SharedPreferences mSharedPreferences;
    private String mSharedPrefFile = "com.example.android.hellosharedsprefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        mSharedPreferences = getSharedPreferences(mSharedPrefFile, MODE_PRIVATE);
        mColor = ContextCompat.getColor(this,
                R.color.default_background);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    /**
     * Handles the onClick for the background color buttons. Gets background
     * color of the button that was clicked, and sets the TextView background
     * to that color.
     *
     * @param view The view (Button) that was clicked.
     */
    public void changeBackground(View view) {
        mColor = ((ColorDrawable) view.getBackground()).getColor();
    }

    public void resetSettings(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        // Reset color
        mColor = ContextCompat.getColor(this,
                R.color.default_background);
        //Resets preferences stored
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt(COLOR_KEY, mColor);
        editor.apply();
        startActivity(intent);
    }

    public void saveSettings(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt(COLOR_KEY, mColor);
        editor.apply();

        startActivity(intent);
    }
}