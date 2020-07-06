package com.example.a42challengeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.phone_input);
        if (editText != null) {
            editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    boolean isHandled = false;
                    if (i == EditorInfo.IME_ACTION_SEND) {
                        dialNumber();
                        isHandled = true;
                    }
                    return isHandled;
                }
            });
        }
    }

    public void dialNumber() {
        String phoneNum = null;

        Intent intent = new Intent(Intent.ACTION_DIAL);
        if (editText != null) {
            phoneNum = "tel:" + editText.getText().toString();
        }
        intent.setData(Uri.parse(phoneNum));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("Error", "The intent isn't passing");
        }

    }
}