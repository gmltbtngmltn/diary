package edu.android.diary;

import android.app.Dialog;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Calendar extends AppCompatActivity {
    private TextView dateDiary;
    private Dialog myDialog;
    private Button btnCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        dateDiary = findViewById(R.id.dateOfDiary);
        btnCalendar = findViewById(R.id.btnCalendar);
        Date d = new Date();
        SimpleDateFormat simple = new SimpleDateFormat("yyyy년mm월dd일");
        dateDiary.setText(simple.format(d));
        myDialog = new Dialog(this);

        btnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v);
            }
        });


    }

    public void showPopup(View v){
        CalendarView calendarView;
        TextView closeView;
        myDialog.setContentView(R.layout.popupcalendar);
        closeView =  (TextView) myDialog.findViewById(R.id.closeView);
        closeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });

        myDialog.show();

    }
}
