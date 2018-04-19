package edu.android.diary;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;


public class DiaryPartMain extends AppCompatActivity {

 CircleMenu circleMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_part_main);
        circleMenu = findViewById(R.id.circle_menu);

        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"), R.mipmap.book, R.mipmap.open_book);
        this.circleMenu.addSubMenu(Color.parseColor("#258CFF"), R.mipmap.shortdiary)
                .addSubMenu(Color.parseColor("#30A400"), R.mipmap.text)
                .addSubMenu(Color.parseColor("#FF4B32"), R.mipmap.movie)
                .addSubMenu(Color.parseColor("#8A39FF"), R.mipmap.letter)
                .addSubMenu(Color.parseColor("#FF6A00"), R.mipmap.film);

       this.circleMenu.setOnMenuSelectedListener(new OnMenuSelectedListener() {

               @Override
                    public void onMenuSelected(int index) {
                            switch (index) {
                                  case 0:

                                      Toast.makeText(DiaryPartMain.this, "100자 기록지", Toast.LENGTH_LONG).show();

                                      Intent intent = new Intent(DiaryPartMain.this, DiaryShortLine.class);
                                      startActivity(intent);
                                          	  break;

                                     case 1:

                                         Toast.makeText(DiaryPartMain.this, "글일기", Toast.LENGTH_LONG).show();
                                         Intent intent2 = new Intent(DiaryPartMain.this, DiaryOnlyText.class);
                                         startActivity(intent2);
                                         break;

                                        case 2:
                                            Toast.makeText(DiaryPartMain.this, "스스로에게 편지쓸래?", Toast.LENGTH_LONG).show();
                                             break;
                                         case 3:
                                               Toast.makeText(DiaryPartMain.this, "사진/영상을 남겨봐", Toast.LENGTH_LONG).show();
                                                  break;
                                         case 4:
                                             Toast.makeText(DiaryPartMain.this, "기록 보러 갈래?", Toast.LENGTH_LONG).show();
                                              break;
                                                                                  }
                                                                              }
                                                                          }
        );
        this.circleMenu.setOnMenuStatusChangeListener(new com.hitomi.cmlibrary.OnMenuStatusChangeListener() {

                                                     @Override
                                                     public void onMenuOpened() {
                                                         Toast.makeText(DiaryPartMain.this, "어떤 일기를 쓸래?", Toast.LENGTH_SHORT).show();
                                                     }

                                                     @Override
                                                     public void onMenuClosed() {
                                                         Toast.makeText(DiaryPartMain.this, "안쓸꺼야 일기?", Toast.LENGTH_SHORT).show();
                                                     }
                                                 }
        );




    }
}
