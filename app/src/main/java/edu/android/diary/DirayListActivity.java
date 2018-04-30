package edu.android.diary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.widget.TextView;

public class DirayListActivity extends AppCompatActivity {

    public TextView textView; // x
    public SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diray_list);

        textView = findViewById(R.id.textView); //x
        searchView = findViewById(R.id.searchView);

        Intent intent = new Intent(this.getIntent());
        int year = getIntent().getIntExtra("SELECTED_YEAR", 1);
        int month = getIntent().getIntExtra("SELECTED_MONTH", 1);
        int day = getIntent().getIntExtra("SELECTED_DAY", 1);
//        String searchDay = year + "년 " + month + "월 " + day + "일";

        textView.setText(year + "년 " + month + "월 " + day + "일");

        //textView.setText();

//        onDateTimeChanged();
    }
}
