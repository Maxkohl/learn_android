package com.example.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

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
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.same_day:
                if (checked) {
                    displayToast(getString(R.string.same_day_message));
                }
                break;
            case R.id.next_day:
                if (checked) {
                    displayToast(getString(R.string.next_day_message));
                }
                break;
            case R.id.pickup:
                if (checked) {
                    displayToast(getString(R.string.self_pickup_message));
                }
                break;
        }
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}