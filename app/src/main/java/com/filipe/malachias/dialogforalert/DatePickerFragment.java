package com.filipe.malachias.dialogforalert;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        // on creation of the Dialog
        // use the current date as the default date in the picker.
        Calendar cal = Calendar.getInstance(); // current calendar date object

        int year = cal.get(Calendar.YEAR); // year as int (2019)
        int month = cal.get(Calendar.MONTH); // month as int (5)
        int day = cal.get(Calendar.DAY_OF_MONTH); // day as int (8)

        // return the dialog object with default date
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
    {
        // gets called when user pick a date
        // 1. get the reference of MainActivity
        MainActivity activity = (MainActivity) getActivity();

        activity.processDatePickerResult (year, month, dayOfMonth);


    }
}
