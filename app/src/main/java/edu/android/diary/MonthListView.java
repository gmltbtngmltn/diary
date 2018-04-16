package edu.android.diary;

/*
    <로 옆에서 달력이 나오고 최근 일기 쓴 목록이 나오는 페이지
 */

import android.annotation.SuppressLint;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MonthListView extends AppCompatActivity {

    FloatingActionButton configuration, mainGo, diaryWrite;
    Button monthButton;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month_list_view);

        monthButton = findViewById(R.id.monthButton);
        monthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
