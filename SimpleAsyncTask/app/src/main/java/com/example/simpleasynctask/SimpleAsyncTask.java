package com.example.simpleasynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import androidx.loader.content.AsyncTaskLoader;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Void, Void, String>{

    private WeakReference<TextView> mTextView;

    public SimpleAsyncTask(TextView mTextView) {
        this.mTextView = new WeakReference<>(mTextView);
    }

    @Override
    protected String doInBackground(Void... voids) {
        Random r = new Random();
        int n = r.nextInt(11);
        int s = n * 200;

        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Awake after sleeping for " + s + " milliseconds!";
    }

    @Override
    protected void onPostExecute(String s) {
        mTextView.get().setText(s);
        super.onPostExecute(s);
    }
}
