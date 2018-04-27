package edu.android.diary;

import android.icu.text.AlphabeticIndex;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;


import java.util.Calendar;

public class Animation extends AppCompatActivity {
    private int currentIndex;
    private CircleMenu circleMenu;
private static int[] IMAGE_IDS={R.drawable.moon00,
        R.drawable.moon01, R.drawable.moon02,
        R.drawable.moon03, R.drawable.moon04,
        R.drawable.moon05, R.drawable.moon06, R.drawable.moon07 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        java.util.Calendar cal = java.util.Calendar.getInstance();
        int year = cal.get(java.util.Calendar.YEAR);
        int month = cal.get(java.util.Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);


        circleMenu = (CircleMenu) findViewById(R.id.circle_menu);

        circleMenu.setMainMenu(Color.parseColor("#00BFFF"), R.mipmap.open_book, R.mipmap.book);
        circleMenu.addSubMenu(Color.parseColor("#7FFFD4"), R.mipmap.film)
                .addSubMenu(Color.parseColor("#1E90FF"), R.mipmap.letter)
                .addSubMenu(Color.parseColor("#4169E1"), R.mipmap.movie)
                .addSubMenu(Color.parseColor("#87CEEB"), R.mipmap.text);

        circleMenu.setOnMenuSelectedListener(new OnMenuSelectedListener() {
            @Override
            public void onMenuSelected(int index) {

                switch (index) {
                    case 0:
                        Intent goDiary = new Intent(Animation.this, Recorde.class);
                        startActivity(goDiary);
                        break;
                    case 1:
                        Intent goCalendar = new Intent(Animation.this, daySearch.class);
                        startActivity(goCalendar);
                        break;
                    case 2:

                        break;
                    case 3:
                        Toast.makeText(Animation.this, "Settings button Clcked", Toast.LENGTH_SHORT).show();
                        break;

                }

            }
        });

        circleMenu.setOnMenuStatusChangeListener(new OnMenuStatusChangeListener() {

                                                     @Override
                                                     public void onMenuOpened() {
                                                         Toast.makeText(Animation.this, "Menu Opend", Toast.LENGTH_SHORT).show();
                                                     }

                                                     @Override
                                                     public void onMenuClosed() {
                                                         Toast.makeText(Animation.this, "Menu Closed", Toast.LENGTH_SHORT).show();
                                                     }
                                                 }
        );


    }

    public void btnPrev(View view) {
        if (currentIndex > 0) {
            currentIndex--;
            view.setBackgroundResource(IMAGE_IDS[currentIndex]);
        } else {
            Toast.makeText(Animation.this, "첫번째 이미지", Toast.LENGTH_SHORT).show();
        }
    }

    public void btnNext(View view) {
        if (currentIndex < IMAGE_IDS.length - 1) {
            currentIndex++;
            view.setBackgroundResource(IMAGE_IDS[currentIndex]);
        } else {
            Toast.makeText(Animation.this, "마지막 이미지", Toast.LENGTH_SHORT).show();
        }
    }
}
