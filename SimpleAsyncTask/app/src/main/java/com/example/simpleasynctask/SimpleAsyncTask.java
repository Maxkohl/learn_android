package com.example.simpleasynctask;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.loader.content.AsyncTaskLoader;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Integer, Integer, String> {

    private WeakReference<TextView> mTextView;
    private ProgressBar progressBar;

    public SimpleAsyncTask(TextView mTextView, ProgressBar progressBar) {
        this.mTextView = new WeakReference<>(mTextView);
        this.progressBar = progressBar;
    }

    @Override
    protected String doInBackground(Integer... values) {
        Random r = new Random();
        int n = r.nextInt(11);
        int s = n * 200;
        int count = 100;

        try {
            Thread.sleep(s);
            for (int i = 0; i < s; i++) {
                publishProgress(i * 200);
                if (isCancelled()) break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Awake after sleeping for " + s + " milliseconds!";
    }

    @Override
    protected void onPostExecute(String s) {
        mTextView.get().setText(s);
    }

    @Override
    protected void onPreExecute() {
        progressBar.setProgress(0);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        progressBar.setProgress(values[0]);
    }
}
