package edu.android.diary;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;

import java.util.Calendar;
import java.util.List;

public class Animation extends AppCompatActivity {
    private int currentIndex;
    private ImageView imggggg;
    private CircleMenu circleMenu;
    private static int[] IMAGE_IDS = {R.drawable.moon00,
            R.drawable.moon01, R.drawable.moon02,
            R.drawable.moon03, R.drawable.moon04,
            R.drawable.moon05, R.drawable.moon06, R.drawable.moon07};

    Button btnDiary,btnRecord,btnThem;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        imggggg = findViewById(R.id.imageView);
        java.util.Calendar cal = java.util.Calendar.getInstance();
        int year = cal.get(java.util.Calendar.YEAR);
        int month = cal.get(java.util.Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);

        btnDiary = findViewById(R.id.btnGoDiary);
        btnRecord = findViewById(R.id.btnRecord);

        btnDiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intGoDiary = new Intent(Animation.this, Recorde.class);
                startActivity(intGoDiary);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        List<Diary> list = DiaryDao.getInstance().getContactList();
        int size = list.size();
        imggggg.setImageResource(IMAGE_IDS[size%7]);


        Log.i(MainActivity.TAG, "list size = " + list.size());
    }
}
