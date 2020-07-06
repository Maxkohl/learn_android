package com.example.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent = getIntent();
        TextView orderMessage = findViewById(R.id.order_message);
        orderMessage.setText(intent.getStringExtra(MainActivity.EXTRA_MESSAGE));

    }

    public void onRadioButtonClicked(View view) {
    }
}