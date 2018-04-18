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

        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"), R.mipmap.icon_menu, R.mipmap.icon_cancel);
        this.circleMenu.addSubMenu(Color.parseColor("#258CFF"), R.mipmap.icon_home)
                .addSubMenu(Color.parseColor("#30A400"), R.mipmap.icon_search)
                .addSubMenu(Color.parseColor("#FF4B32"), R.mipmap.icon_notify)
                .addSubMenu(Color.parseColor("#8A39FF"), R.mipmap.icon_setting)
                .addSubMenu(Color.parseColor("#FF6A00"), R.mipmap.icon_gps);

       this.circleMenu.setOnMenuSelectedListener(new OnMenuSelectedListener() {

               @Override
                    public void onMenuSelected(int index) {
                            switch (index) {
                                  case 0:

//                                      Toast.makeText(DiaryPartMain.this, "Home button Clicked", Toast.LENGTH_SHORT).show();

                                      Intent intent = new Intent(DiaryPartMain.this, DiaryShortLine.class);
                                      startActivity(intent);


                                          	  break;
                                     case 1:
                                         Toast.makeText(DiaryPartMain.this, "Search button Clicked", Toast.LENGTH_SHORT).show();
                                              break;
                                        case 2:
                                           Toast.makeText(DiaryPartMain.this, "Notify button Clciked", Toast.LENGTH_SHORT).show();
                                             break;
                                         case 3:
                                               Toast.makeText(DiaryPartMain.this, "Settings button Clcked", Toast.LENGTH_SHORT).show();
                                                  break;
                                         case 4:
                                             Toast.makeText(DiaryPartMain.this, "GPS button Clicked", Toast.LENGTH_SHORT).show();
                                              break;
                                                                                  }
                                                                              }
                                                                          }
        );
        this.circleMenu.setOnMenuStatusChangeListener(new com.hitomi.cmlibrary.OnMenuStatusChangeListener() {

                                                     @Override
                                                     public void onMenuOpened() {
                                                         Toast.makeText(DiaryPartMain.this, "Menu Opend", Toast.LENGTH_SHORT).show();
                                                     }

                                                     @Override
                                                     public void onMenuClosed() {
                                                         Toast.makeText(DiaryPartMain.this, "Menu Closed", Toast.LENGTH_SHORT).show();
                                                     }
                                                 }
        );




    }
}
