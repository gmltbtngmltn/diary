package edu.android.diary;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.SearchView;
import android.widget.TextView;

public class DirayListActivity extends AppCompatActivity {

    public TextView textView; // x
    public SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diray_list);

        textView = findViewById(R.id.textView7); //x
        searchView = findViewById(R.id.searchView);

        Intent intent = getIntent();
        int year = intent.getIntExtra("SELECTED_YEAR", 1);
        int month = intent.getIntExtra("SELECTED_MONTH", 1);
        int day = intent.getIntExtra("SELECTED_DAY", 1);
//        String searchDay = year + "년 " + month + "월 " + day + "일";

        textView.setText(year + "년 " + month + "월 " + day + "일");

        //textView.setText();


        FragmentManager fm=getSupportFragmentManager();
        Fragment fragment=fm.findFragmentById(R.id.container);
        if(fragment==null){
            FragmentTransaction transaction=fm.beginTransaction();
            DiaryList_FragmentViewfliper diaryList_fragmentViewfliper=new DiaryList_FragmentViewfliper();
            transaction.replace(R.id.container,diaryList_fragmentViewfliper);
            transaction.commit();
        }
//        onDateTimeChanged();
    }
}
