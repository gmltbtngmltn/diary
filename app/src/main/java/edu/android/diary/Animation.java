package edu.android.diary;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;

public class Animation extends AppCompatActivity {

    private CircleMenu circleMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);


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
                        Intent intent = new Intent(Animation.this, DiaryPart.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent2 = new Intent(Animation.this, daySearch.class);
                        startActivity(intent2);
                        break;
                    case 2:
                        Toast.makeText(Animation.this, "Notify button Clciked", Toast.LENGTH_SHORT).show();
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

}
