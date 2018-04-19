package edu.android.diary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Calendar extends AppCompatActivity {
    private TextView dateDiary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        dateDiary = findViewById(R.id.dateDiary);
        Date d = new Date();
        SimpleDateFormat simple = new SimpleDateFormat("yyyy년mm월dd일");
        dateDiary.setText(simple.format(d));


    }
}
