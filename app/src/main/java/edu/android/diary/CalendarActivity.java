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
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CalendarActivity extends AppCompatActivity {
    private TextView dateDiary,script;
    private ImageView images;
    private Dialog myDialog;
    private Button btnCalendar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        dateDiary = findViewById(R.id.dateOfDiary);
        btnCalendar = findViewById(R.id.btnCalendar);
        script = findViewById(R.id.script);
        images = findViewById(R.id.images);
        Date d = new Date();
        SimpleDateFormat simple = new SimpleDateFormat("yyyy년MM월dd일");
        dateDiary.setText(simple.format(d));
        myDialog = new Dialog(this);

        btnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v);
            }
        });
        //todo: 데이터베이스에서 날짜 카운팅후 갯수만큼 프레그레스바 에 적용때리기.


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

        //todo: 일기를 쓴 날짜에 표시되는 기능 필요. 머테리얼캘린더뷰 이용.
        //todo: 데이터베이스에서 검색 , 조건문써서 날짜표시

    }



}
