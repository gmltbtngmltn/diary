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

import static edu.android.diary.mot.*;

public class Calendar extends AppCompatActivity {
    private TextView dateDiary,script;
    private ImageView images;
    private Dialog myDialog;
    private Button btnCalendar, nextMot;



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

        nextMot = findViewById(R.id.nextMot);
        nextMot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = script.getText().toString();
                if (text.equals(MESSAGE1)) {
                    script.setText(MESSAGE2);
                }else if (text.equals(MESSAGE2)) {
                    script.setText(MESSAGE3);
                }else if (text.equals(MESSAGE3)) {
                    script.setText(MESSAGE4);
                }else if (text.equals(MESSAGE4)) {
                    script.setText(MESSAGE5);
                }else if (text.equals(MESSAGE5)) {
                    script.setText(MESSAGE6);
                }else if (text.equals(MESSAGE6)) {
                    script.setText(MESSAGE7);
                }else if (text.equals(MESSAGE7)) {
                    script.setText(MESSAGE8);
                }else if (text.equals(MESSAGE8)) {
                    script.setText(MESSAGE9);
                }else if (text.equals(MESSAGE9)) {
                    script.setText(MESSAGE10);
                }else if (text.equals(MESSAGE10)) {
                    script.setText(MESSAGE11);
                }else if (text.equals(MESSAGE11)) {
                    script.setText(MESSAGE12);
                }else if (text.equals(MESSAGE12)) {
                    script.setText(MESSAGE13);
                }else if (text.equals(MESSAGE13)) {
                    script.setText(MESSAGE14);
                }else if (text.equals(MESSAGE14)) {
                    script.setText(MESSAGE15);
                }else if (text.equals(MESSAGE15)) {
                    script.setText(MESSAGE16);
                }else if (text.equals(MESSAGE16)) {
                    script.setText(MESSAGE17);
                }else if (text.equals(MESSAGE17)) {
                    script.setText(MESSAGE18);
                }else if (text.equals(MESSAGE18)) {
                    script.setText(MESSAGE19);
                }else if (text.equals(MESSAGE19)) {
                    script.setText(MESSAGE20);
                }else if (text.equals(MESSAGE20)) {
                    script.setText(MESSAGE21);
                }else if (text.equals(MESSAGE21)) {
                    script.setText(MESSAGE22);
                }else if (text.equals(MESSAGE22)) {
                    script.setText(MESSAGE23);
                }else if (text.equals(MESSAGE23)) {
                    script.setText(MESSAGE24);
                }else if (text.equals(MESSAGE24)) {
                    script.setText(MESSAGE25);
                }else if (text.equals(MESSAGE25)) {
                    script.setText(MESSAGE1);
                }
            }//end onClick
        });

        btnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v);
            }
        });
        //todo: 데이터베이스에서 날짜 카운팅후 갯수만큼 프레그레스바 에 적용때리기.


    }

    public void showPopup(View v) {
        CalendarView calendarView;
        TextView closeView;
        myDialog.setContentView(R.layout.popupcalendar);
        closeView = (TextView) myDialog.findViewById(R.id.closeView);
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

    public void nextMot(View view) {
//         mot m = new mot();
//         int image = m.mots[1];
//         images.setImageResource(image);

//        String text = script.getText().toString();
//        if (text.equals(MESSAGE1)) {
//            script.setText(MESSAGE2);
//        }else if (text.equals(MESSAGE2)) {
//            script.setText(MESSAGE3);
//        }else if (text.equals(MESSAGE3)) {
//            script.setText(MESSAGE4);
//        }else if (text.equals(MESSAGE4)) {
//            script.setText(MESSAGE5);
//        }else if (text.equals(MESSAGE5)) {
//            script.setText(MESSAGE6);
//        }else if (text.equals(MESSAGE6)) {
//            script.setText(MESSAGE7);
//        }else if (text.equals(MESSAGE7)) {
//            script.setText(MESSAGE8);
//        }else if (text.equals(MESSAGE8)) {
//            script.setText(MESSAGE9);
//        }else if (text.equals(MESSAGE9)) {
//            script.setText(MESSAGE10);
//        }else if (text.equals(MESSAGE10)) {
//            script.setText(MESSAGE11);
//        }else if (text.equals(MESSAGE11)) {
//            script.setText(MESSAGE12);
//        }else if (text.equals(MESSAGE12)) {
//            script.setText(MESSAGE13);
//        }else if (text.equals(MESSAGE13)) {
//            script.setText(MESSAGE14);
//        }else if (text.equals(MESSAGE14)) {
//            script.setText(MESSAGE15);
//        }else if (text.equals(MESSAGE15)) {
//            script.setText(MESSAGE16);
//        }else if (text.equals(MESSAGE16)) {
//            script.setText(MESSAGE17);
//        }else if (text.equals(MESSAGE17)) {
//            script.setText(MESSAGE18);
//        }else if (text.equals(MESSAGE18)) {
//            script.setText(MESSAGE19);
//        }else if (text.equals(MESSAGE19)) {
//            script.setText(MESSAGE20);
//        }else if (text.equals(MESSAGE20)) {
//            script.setText(MESSAGE21);
//        }else if (text.equals(MESSAGE21)) {
//            script.setText(MESSAGE22);
//        }else if (text.equals(MESSAGE22)) {
//            script.setText(MESSAGE23);
//        }else if (text.equals(MESSAGE23)) {
//            script.setText(MESSAGE24);
//        }else if (text.equals(MESSAGE24)) {
//            script.setText(MESSAGE25);
//        }else if (text.equals(MESSAGE25)) {
//            script.setText(MESSAGE1);
//        }

    }
}

