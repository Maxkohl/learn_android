package com.example.simpleasynctask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final static String TEXT_STATE = "currentText";

    private TextView mTextView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.textView1);
        progressBar = findViewById(R.id.determinateBar);

        if (savedInstanceState != null) {
            mTextView.setText(savedInstanceState.getString(TEXT_STATE));
        }
    }

    public void startTask(View view) {
        mTextView.setText(R.string.napping);
        new SimpleAsyncTask(mTextView, progressBar).execute(10);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(TEXT_STATE, mTextView.getText().toString());
        super.onSaveInstanceState(outState);
    }
}