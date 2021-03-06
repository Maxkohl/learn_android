package com.example.pickedfordate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),
                getString(R.string.date_picker_text));
    }

    public void processDatePicketResults(int year, int month, int day) {
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (month_string +
                "/" + day_string + "/" + year_string);

        Toast.makeText(this, getString(R.string.date_toast) + dateMessage,
                Toast.LENGTH_SHORT).show();
    }

    public void showTimePicker(View view) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), getString(R.string.time_picker));

    }

    public void processTimePickerResults(int hour, int minute) {
        String time_hour = Integer.toString(hour);
        String time_minute = Integer.toString(minute);
        String timeMessage = "Time Picked: " + time_hour + ":" + time_minute;

        Toast.makeText(this, timeMessage, Toast.LENGTH_SHORT).show();
    }
}