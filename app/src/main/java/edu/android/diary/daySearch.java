package edu.android.diary;

import java.util.Calendar;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;

public class daySearch extends Activity {

    private static final String TAG = "CalendarActivity";

    private CalendarView mCalendarView;
    private TextView dayday;
    private Button monthSearch;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daysearch);
        mCalendarView = (CalendarView) findViewById(R.id.calendarView);
        dayday = findViewById(R.id.dayday);

        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int day) {
                String date = year + "/" + month + "/" + day;
                Log.d(TAG, "onSelectedDayChange: yyyy/MM/dd: " + date);

                dayday.setText(date);
            }
        });

        monthSearch = findViewById(R.id.monthSearch);
        monthSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        daySearch.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: yyyy/MM/dd: " + year + "/" + month + "/" + day);

                String date = year + "/" + month + "/" + day;
                dayday.setText(date);
            }
        };
    }

}