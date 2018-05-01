package edu.android.diary;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

import static edu.android.diary.DaySearch.*;

public class DirayListActivity extends AppCompatActivity {

    public TextView textView; // x
    public SearchView searchView;
    private Button button;


    private FragmentManager fm;
    private FragmentTransaction transaction;

    private int show;
    private int comm;

    private int year;
    private int month;
    private int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diray_list);

        textView = findViewById(R.id.textView7); //x
        searchView = findViewById(R.id.searchView);
        button=findViewById(R.id.modechange);

        Intent intent = getIntent();
        year = intent.getIntExtra(SELECTED_YEAR, 1);
        month = intent.getIntExtra(SELECTED_MONTH, 1);
        day = intent.getIntExtra(SELECTED_DAY, 1);
        comm=intent.getIntExtra(COMM,0);
//        String searchDay = year + "년 " + month + "월 " + day + "일";
        Log.i("aaaa","comm = "+comm);
        textView.setText(year + "년 " + month + "월 " + day + "일");

        //textView.setText();
        fm=getSupportFragmentManager();
        Fragment fragment=fm.findFragmentById(R.id.container);
        if(fragment==null){
            transaction=fm.beginTransaction();
            DiaryList_FragmentViewpager diaryList_fragmentViewpager = DiaryList_FragmentViewpager.newInstance(comm,year,month,day);
            transaction.replace(R.id.container, diaryList_fragmentViewpager);
            transaction.commit();
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(show==0){
                    transaction=fm.beginTransaction();
                    DiaryList_FragmentRecycler diaryList_fragmentRecycler = DiaryList_FragmentRecycler.newInstance(comm,year,month,day);
                    transaction.replace(R.id.container,diaryList_fragmentRecycler);
                    transaction.commit();
                    show=1;
                }else if(show==1){
                    transaction=fm.beginTransaction();
                    DiaryList_FragmentViewpager diaryList_fragmentViewpager = DiaryList_FragmentViewpager.newInstance(comm,year,month,day);
                    transaction.replace(R.id.container, diaryList_fragmentViewpager);
                    transaction.commit();
                    show=0;
                }
            }
        });

//        onDateTimeChanged();
    }
}
