package com.filipe.malachias.dialogforalert;

import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCLickShowAlert(View view)
    {
        // 1. Create a Dialog Builder
        AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(MainActivity.this);
        myAlertBuilder.setTitle("Alert"); // set title
        myAlertBuilder.setMessage("Click OK to continue, or CANCEL to stop"); // set message

        // 2. Set Buttons (Positive Button, Negative Button)
        myAlertBuilder.setPositiveButton("OK", /* listener */ new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                // when user clicked OK button
                Toast.makeText(getApplicationContext(), "OK Tapped", Toast.LENGTH_SHORT).show();
            }
        });
        myAlertBuilder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // when user clicked CANCEL button
                Toast.makeText(getApplicationContext(), "CANCEL taped", Toast.LENGTH_SHORT).show();
            }
        });

        // 3. show the alert dialog
        myAlertBuilder.show();
    }

    public void processDatePickerResult (int year, int month, int day)
    {
        // display date
        Toast.makeText(this, "Year: " + year + ", Month: " + (month+1) + ", Day: " + day, Toast.LENGTH_SHORT).show();
    }

    public void showDatePicker(View view)
    {
        DialogFragment datePickerFragment = new DatePickerFragment();
        datePickerFragment.show(getSupportFragmentManager(),"datePicker");
    }
}
