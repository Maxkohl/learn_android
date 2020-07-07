package com.example.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private int score1;
    private int score2;
    private TextView mScore1Text;
    private TextView mScore2Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScore1Text = (TextView)findViewById(R.id.score_team1);
        mScore2Text = (TextView)findViewById(R.id.score_team2);

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
}