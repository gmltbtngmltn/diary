package edu.android.diary;

import android.support.v7.app.AppCompatActivity;

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
