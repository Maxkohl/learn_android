package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mWebsiteEditText;
    private EditText mLocEditText;
    private EditText mShareEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebsiteEditText = findViewById(R.id.website_edittext);
        mLocEditText = findViewById(R.id.loc_edittext);
        mShareEditText = findViewById(R.id.share_edittext);

    }

    public void openWebsite(View view) {
    }

    public void openLocation(View view) {
    }

    public void shareText(View view) {
    }
}