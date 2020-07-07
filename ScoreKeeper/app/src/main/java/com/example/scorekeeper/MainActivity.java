package com.example.scorekeeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private int score1;
    private int score2;
    private TextView mScore1Text;
    private TextView mScore2Text;
    final static String STATE_SCORE_1 = "Team 1 Score";
    final static String STATE_SCORE_2 = "Team 2 Score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScore1Text = (TextView) findViewById(R.id.score_team1);
        mScore2Text = (TextView) findViewById(R.id.score_team2);

        if (savedInstanceState != null) {
            score1 = savedInstanceState.getInt(STATE_SCORE_1);
            score2 = savedInstanceState.getInt(STATE_SCORE_2);
            mScore1Text.setText(String.valueOf(score1));
            mScore2Text.setText(String.valueOf(score2));
        }

    }

    public void decreaseScore(View view) {
        int viewID = view.getId();
        switch (viewID) {
            case R.id.decrease_team1:
                score1--;
                mScore1Text.setText(String.valueOf(score1));
                break;
            case R.id.decrease_team2:
                score2--;
                mScore2Text.setText(String.valueOf(score2));
                break;
        }
    }

    public void increaseScore(View view) {
        int viewID = view.getId();
        switch (viewID) {
            case R.id.increase_team1:
                score1++;
                mScore1Text.setText(String.valueOf(score1));
                break;
            case R.id.increase_team2:
                score2++;
                mScore2Text.setText(String.valueOf(score2));
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        // Change the label of the menu based on the state of the app.
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.night_mode) {
            // Get the night mode state of the app.
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            //Set the theme mode for the restarted activity
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode
                        (AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode
                        (AppCompatDelegate.MODE_NIGHT_YES);
            }
            // Recreate the activity for the theme change to take effect.
            recreate();

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(STATE_SCORE_1, score1);
        outState.putInt(STATE_SCORE_2, score2);
        super.onSaveInstanceState(outState);
    }
}