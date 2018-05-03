package edu.android.diary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Calendar;
import java.util.List;
import static edu.android.diary.SetThema.*;

public class Animation extends AppCompatActivity {
    public static final String QUE="qqqq";
    public static final int REQ_CODE = 100;

    Button btnDiary,btnRecord,btnThem;

    private int comm;
    FragmentManager fm=getSupportFragmentManager();
    FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        comm=loadthemenum();

        if(comm==0){
            comm=1;
        }

        java.util.Calendar cal = java.util.Calendar.getInstance();
        int year = cal.get(java.util.Calendar.YEAR);
        int month = cal.get(java.util.Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);

        btnDiary = findViewById(R.id.btnGoDiary);

        btnRecord = findViewById(R.id.btnRecord);

        btnThem = findViewById(R.id.btnThem);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intGoThem = new Intent(Animation.this, SetThema.class);
                startActivityForResult(intGoThem, REQ_CODE);
            }
        });

        btnDiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intGoDiary = new Intent(Animation.this, Recorde.class);
                intGoDiary.putExtra(QUE,0);//쓰러갈때 명령값은 0으로한다
                startActivity(intGoDiary);
            }
        });

        btnRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intGoRecord = new Intent(Animation.this, DaySearch.class);
                startActivity(intGoRecord);
            }
        });

        transaction=getSupportFragmentManager().beginTransaction();
        ThemaFragment themaFragment= ThemaFragment.newInstance(comm);
        transaction.replace(R.id.containerTH,themaFragment);
        transaction.commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQ_CODE && resultCode == RESULT_OK) {
            comm = data.getIntExtra(AAA,1);
            Log.i("aaaa",""+comm);
            changeFrag();
        }
    }

    void changeFrag(){
        transaction=getSupportFragmentManager().beginTransaction();
        Log.i("aaaa","aannmmm22  "+comm);
        ThemaFragment themaFragment= ThemaFragment.newInstance(comm);
        transaction.replace(R.id.containerTH,themaFragment);
        transaction.commitAllowingStateLoss();
    }

    public int loadthemenum(){
        return DiaryDao.getInstance().getThemeNum();
    }
}
