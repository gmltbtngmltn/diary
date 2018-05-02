package edu.android.diary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;

public class DaySearchPage extends AppCompatActivity {

    public static final String SELECTED_YEAR="sELECTED_YEAR";
    public static final String SELECTED_MONTH="sELECTED_MONTH";
    public static final String SELECTED_DAY="sELECTED_DAY";
    public static final String COMM="comm";

    private DatePicker datePicker;
    private Button check;

    public int curYear;
    public int curMonth;
    public int curDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daysearch);

        Calendar calendar = Calendar.getInstance();
        curYear = calendar.get(Calendar.YEAR);
        curMonth = calendar.get(Calendar.MONTH);
        curDay = calendar.get(Calendar.DAY_OF_MONTH);

        datePicker = findViewById(R.id.datePicker);
        datePicker.init(curYear, curMonth, curDay, new DatePicker.OnDateChangedListener() {
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // 새로 정의한 리스너로 이벤트 전달
                // getHour(), getMinute() 메소드는 API 23부터 지원함
                curYear = year;
                curMonth = monthOfYear + 1;
                curDay = dayOfMonth;
                //Toast.makeText(MainActivity.this, "year:" + year + "month:" + monthOfYear + "day:" + dayOfMonth, Toast.LENGTH_LONG).show();
            }
        });
        check = findViewById(R.id.check);
    }

    public void next(View v) {
        Intent intent = new Intent(DaySearchPage.this, DirayListActivity.class);
        intent.putExtra(SELECTED_YEAR, curYear);
        intent.putExtra(SELECTED_MONTH, curMonth);
        intent.putExtra(SELECTED_DAY, curDay);
        intent.putExtra(COMM,1);

        startActivity(intent);
    }

    public void bot_ki(View view) {
        Intent intent = new Intent(DaySearchPage.this, DirayListActivity.class);
        intent.putExtra(SELECTED_YEAR, curYear);
        intent.putExtra(SELECTED_MONTH, curMonth);
        intent.putExtra(SELECTED_DAY, curDay);
        intent.putExtra(COMM,0);

        startActivity(intent);
    }
}

