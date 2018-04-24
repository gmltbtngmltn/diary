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
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Calendar extends AppCompatActivity {

    public static final String MESSAGE1 = "사랑받고 싶다면 사랑하라, 그리고 사랑스럽게 행동하라 -벤자민 프랭클린";
    public static final String MESSAGE2 = "정성과 마음을 다하고 생각이 깊은 사람일수록 상대방에게 정성과 진실한 마음을 더욱더 발견하게 된다\n" +
            "-톨스토이";
    public static final String MESSAGE3 = "누구도 지신이 받은 것으로 인해 존경받지 않는다\n" +
            "존경은 자신이 베푼 것에 대한 보답이다\n" +
            "-캘빈 쿨리지";
    public static final String MESSAGE4 = "가장 어두운 시간은 해뜨기 바로 직전의 시간이다\n" +
            "-파울로 코엘료";
    public static final String MESSAGE5 = "자기 자신을 희생하는 것처럼 행복한 일은 없다\n" +
            "-도스토예프스키";
    public static final String MESSAGE6 = "어제는 과거이고, 내일은 미래이고 그리고 오늘은 선물입니다\n" +
            "그래서 오늘은 현재(present=선물)라고 불립니다\n" +
            "-빌 킨";
    public static final String MESSAGE7 = "아이들에게 꾸지람보다는 좋은 본보기가 더 절실하게 필요하다\n" +
            "-주베르";
    public static final String MESSAGE8 = "부모란 자녀에게 사소한 어떤 것을 줘서 아이가 행복하도록 만들어주는 존재이다\n" +
            "-오그든 내시";
    public static final String MESSAGE9 = "나는 항상 항상 나의 밖에서 강점과 자신감을 찾았지만,\n" +
            "그것은 내 안에서 나오는 것이다.\n" +
            "그것은 항상 거기에 있다\n" +
            "-안나 프로이드";
    public static final String MESSAGE10 = "믿음이 있는 사람에게는 어떠한 설명도 필요 없다\n" +
            "믿음이 없는 이에게는 어떠한 설명도 불가능하다\n" +
            "-토마스 아퀴나스";
    public static final String MESSAGE11 = "당신이 몇 살이든, 어떤 환경에서 자랐든,\n" +
            "어떤 교육을 받았든, 당신의 대부분을 이루고 있는 것은\n" +
            "개발되지 않는 잠재력이다\n" +
            "-조지 레오나르드";
    public static final String MESSAGE12 = "자신을 한계 짓지 말라\n" +
            "많은 이들이 자신이 할 수 있는 것에 대해 한계를 정한다\n" +
            "당신은 당신의 마음이 정하는 만큼 갈 수 있다\n" +
            "당신이 믿는 것, 당신은 그것을 성취할 수 있다\n" +
            "-메리 케이 애시";
    public static final String MESSAGE13 = "지혜는 그 어떤 재산보다 더 중요하다\n" +
            "-소포클레스";
    public static final String MESSAGE14 = "자신에 대해 긍정적인 생각을 하는 방법은\n" +
            "긍정적인 행동을 하는 것이다\n" +
            "사람들은 생각한 대로 살지 않으면 사는 대로 생각한다\n" +
            "-폴 발레리";
    public static final String MESSAGE15 = "내 경험으로는 항상'그저 어린애'와 함께하는 것이 '그저 어른'과 함께하는\n" +
            "것보다 훨씬 더 나았기 대문에 '그저 어린애'라는 말을 문제삼을 수 밖에 없다\n" +
            "-프란 레보비츠";
    public static final String MESSAGE16 = "정말 위대하고 감동적인 모든 것은 자유 안에서 일할 수 있는 것들에 의해 창조된다\n" +
            "-알버트 아인슈타인";
    public static final String MESSAGE17 = "전쟁에서 이기기란 지진을 이기는 것과 마찬가지다\n" +
            "-재닛 랜킨";
    public static final String MESSAGE18 = "바로 지금 여기 앉아 아픔과 기쁨을 느끼는 우리의 신체야 말로 우리가 온전한 인간이 되고 완전히\n" +
            "깨어 완전히 살기 위해 필요한 바로 그것 임을 깨닫는 것 역시 도움이 된다\n" +
            "-페마 코드론";
    public static final String MESSAGE19 = "(기억이란)인간의 진정한 재산이다, 기억 속의 인간은 가장 부유하면서 또 가장 빈곤하다\n" +
            "-알렉산더 스미스";
    public static final String MESSAGE20 = "웃음은 두 사람간의 가장 가까운 거리이다\n" +
            "-빅터 보르게";
    public static final String MESSAGE21 = "우리는 다른 사람이 욕심을 낼 때 겁을 내려고 하고, 다른 사람이 겁을 낼 때만 욕심을 부리곤 한다\n" +
            "-워런 버펏";
    public static final String MESSAGE22 = "중요한 것은 사랑을 받는 것이 아니라 사랑을 하는 것이었다.\n" +
            "-월리엄 서머셋 모옴";
    public static final String MESSAGE23 = "한 사람이 다른 한 사람을 사랑하는 것. 이는 모든 일 중 가장 어려운 일이고, 궁극적인\n" +
            "최후의 시험이자 증명이며, 그 외 모든 일은 이를 위한 준비일 뿐이다.\n" +
            "-라이너 마리아 릴케";
    public static final String MESSAGE24 = "부자가 되려면 부자들과 어울려 살아가는 끔찍함을 견뎌야 한다\n" +
            "-로건 피어설 스미스";
    public static final String MESSAGE25 = "명확한 목표는 말의 곁눈 가리개처럼 목표를 가진 이의 시야를 좁게 하기 마련이다\n" +
            "-로버트 프로스트";

    private TextView dateDiary, script, textView;
    private ImageView images;
    private Dialog myDialog;
    private Button btnCalendar, nextMot, next, prev;
    private int CURRENT_INDEX; // 이미지
    private ImageView[] imageViews; // 이미지


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        dateDiary = findViewById(R.id.dateOfDiary);
        btnCalendar = findViewById(R.id.btnCalendar);
        images = findViewById(R.id.image);
        imageViews = findViewById(R.id.imageView);
        next = findViewById(R.id.next);
        prev = findViewById(R.id.prev);
        textView = findViewById(R.id.script);
        Date d = new Date();
        SimpleDateFormat simple = new SimpleDateFormat("yyyy년MM월dd일");
        dateDiary.setText(simple.format(d));
        myDialog = new Dialog(this);

//        next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String text = next.getText().toString();
//                if (text.equals(MESSAGE1)) {
//                    next.setText(MESSAGE2);
//                } else if (text.equals(MESSAGE25)) {
//                    next.setText(MESSAGE1);
//                }
//            }//end onClick
//        });
//        prev.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String text2 = prev.getText().toString();
//                if (text2.equals(MESSAGE1)) {
//                    prev.setText(MESSAGE2);
//                } else if (text2.equals(MESSAGE25)) {
//                    prev.setText(MESSAGE1);
//                }
//            }//end onClick
//        });

//        textvView();

        init(); // 이미지

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

    private void init() {

        ImageView imageView1 = (ImageView) findViewById(R.id.image1);
        ImageView imageView2 = (ImageView) findViewById(R.id.image2);
        ImageView imageView3 = (ImageView) findViewById(R.id.image3);
        ImageView imageView4 = (ImageView) findViewById(R.id.image4);
        ImageView imageView5 = (ImageView) findViewById(R.id.image5);
        ImageView imageView6 = (ImageView) findViewById(R.id.image6);
        ImageView imageView7 = (ImageView) findViewById(R.id.image7);
        ImageView imageView8 = (ImageView) findViewById(R.id.image8);
        ImageView imageView9 = (ImageView) findViewById(R.id.image9);
        ImageView imageView10 = (ImageView) findViewById(R.id.image10);
        ImageView imageView11 = (ImageView) findViewById(R.id.image11);
        ImageView imageView12 = (ImageView) findViewById(R.id.image12);
        ImageView imageView13 = (ImageView) findViewById(R.id.image13);
        ImageView imageView14 = (ImageView) findViewById(R.id.image14);
        ImageView imageView15 = (ImageView) findViewById(R.id.image15);
        ImageView imageView16 = (ImageView) findViewById(R.id.image16);
        ImageView imageView17 = (ImageView) findViewById(R.id.image17);
        ImageView imageView18 = (ImageView) findViewById(R.id.image18);
        ImageView imageView19 = (ImageView) findViewById(R.id.image19);
        ImageView imageView20 = (ImageView) findViewById(R.id.image20);
        ImageView imageView21 = (ImageView) findViewById(R.id.image21);
        ImageView imageView22 = (ImageView) findViewById(R.id.image22);
        ImageView imageView23 = (ImageView) findViewById(R.id.image23);
        ImageView imageView24 = (ImageView) findViewById(R.id.image24);
        ImageView imageView25 = (ImageView) findViewById(R.id.image25);

        imageViews = new ImageView[]{
                imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8,
                imageView9, imageView10, imageView11, imageView12, imageView13, imageView14, imageView15, imageView16,
                imageView17, imageView18, imageView19, imageView20, imageView21, imageView22, imageView23, imageView24, imageView25
        };
        imageView1.setVisibility(View.VISIBLE);
        CURRENT_INDEX = 0;
    }

    public void onClickNext(View view) {

        if (++CURRENT_INDEX > 24) {
            Toast toast = Toast.makeText(this, "마지막 명언 입니다.", Toast.LENGTH_SHORT);
            toast.show();

            CURRENT_INDEX--;
        } else {
            for (int i = 0; i < imageViews.length; i++) {
                if (i == CURRENT_INDEX) {
                    imageViews[i].setVisibility(View.VISIBLE);
                } else {
                    imageViews[i].setVisibility(View.INVISIBLE);
                }
            }
        }

        String text = textView.getText().toString();
        if (text.equals(MESSAGE1)) {
            textView.setText(MESSAGE2);
        } else if (text.equals(MESSAGE2)) {
            textView.setText(MESSAGE3);
        } else if (text.equals(MESSAGE3)) {
            textView.setText(MESSAGE4);
        } else if (text.equals(MESSAGE4)) {
            textView.setText(MESSAGE5);
        } else if (text.equals(MESSAGE5)) {
            textView.setText(MESSAGE6);
        } else if (text.equals(MESSAGE6)) {
            textView.setText(MESSAGE7);
        } else if (text.equals(MESSAGE7)) {
            textView.setText(MESSAGE8);
        } else if (text.equals(MESSAGE8)) {
            textView.setText(MESSAGE9);
        } else if (text.equals(MESSAGE9)) {
            textView.setText(MESSAGE10);
        } else if (text.equals(MESSAGE10)) {
            textView.setText(MESSAGE11);
        } else if (text.equals(MESSAGE11)) {
            textView.setText(MESSAGE12);
        } else if (text.equals(MESSAGE12)) {
            textView.setText(MESSAGE13);
        } else if (text.equals(MESSAGE13)) {
            textView.setText(MESSAGE14);
        } else if (text.equals(MESSAGE14)) {
            textView.setText(MESSAGE15);
        } else if (text.equals(MESSAGE15)) {
            textView.setText(MESSAGE16);
        } else if (text.equals(MESSAGE16)) {
            textView.setText(MESSAGE17);
        } else if (text.equals(MESSAGE17)) {
            textView.setText(MESSAGE18);
        } else if (text.equals(MESSAGE18)) {
            textView.setText(MESSAGE19);
        } else if (text.equals(MESSAGE19)) {
            textView.setText(MESSAGE20);
        } else if (text.equals(MESSAGE20)) {
            textView.setText(MESSAGE21);
        } else if (text.equals(MESSAGE21)) {
            textView.setText(MESSAGE22);
        } else if (text.equals(MESSAGE22)) {
            textView.setText(MESSAGE23);
        } else if (text.equals(MESSAGE23)) {
            textView.setText(MESSAGE24);
        } else if (text.equals(MESSAGE24)) {
            textView.setText(MESSAGE25);
        } else if (text.equals(MESSAGE25)) {
            textView.setText(MESSAGE1);
        }


    }

    public void onClickPrev(View view) {


        if (--CURRENT_INDEX < 0) {
            Toast toast = Toast.makeText(this, "처음 명언 입니다.", Toast.LENGTH_SHORT);
            toast.show();

            CURRENT_INDEX++;
        } else {
            for (int i = 0; i < imageViews.length; i++) {
                if (i == CURRENT_INDEX) {
                    imageViews[i].setVisibility(View.VISIBLE);
                } else {
                    imageViews[i].setVisibility(View.INVISIBLE);
                }
            }
        }

        String text2 = textView.getText().toString();
        if (text2.equals(MESSAGE1)) {
            textView.setText(MESSAGE2);
        } else if (text2.equals(MESSAGE2)) {
            textView.setText(MESSAGE3);
        } else if (text2.equals(MESSAGE3)) {
            textView.setText(MESSAGE4);
        } else if (text2.equals(MESSAGE4)) {
            textView.setText(MESSAGE5);
        } else if (text2.equals(MESSAGE5)) {
            textView.setText(MESSAGE6);
        } else if (text2.equals(MESSAGE6)) {
            textView.setText(MESSAGE7);
        } else if (text2.equals(MESSAGE7)) {
            textView.setText(MESSAGE8);
        } else if (text2.equals(MESSAGE8)) {
            textView.setText(MESSAGE9);
        } else if (text2.equals(MESSAGE9)) {
            textView.setText(MESSAGE10);
        } else if (text2.equals(MESSAGE10)) {
            textView.setText(MESSAGE11);
        } else if (text2.equals(MESSAGE11)) {
            textView.setText(MESSAGE12);
        } else if (text2.equals(MESSAGE12)) {
            textView.setText(MESSAGE13);
        } else if (text2.equals(MESSAGE13)) {
            textView.setText(MESSAGE14);
        } else if (text2.equals(MESSAGE14)) {
            textView.setText(MESSAGE15);
        } else if (text2.equals(MESSAGE15)) {
            textView.setText(MESSAGE16);
        } else if (text2.equals(MESSAGE16)) {
            textView.setText(MESSAGE17);
        } else if (text2.equals(MESSAGE17)) {
            textView.setText(MESSAGE18);
        } else if (text2.equals(MESSAGE18)) {
            textView.setText(MESSAGE19);
        } else if (text2.equals(MESSAGE19)) {
            textView.setText(MESSAGE20);
        } else if (text2.equals(MESSAGE20)) {
            textView.setText(MESSAGE21);
        } else if (text2.equals(MESSAGE21)) {
            textView.setText(MESSAGE22);
        } else if (text2.equals(MESSAGE22)) {
            textView.setText(MESSAGE23);
        } else if (text2.equals(MESSAGE23)) {
            textView.setText(MESSAGE24);
        } else if (text2.equals(MESSAGE24)) {
            textView.setText(MESSAGE25);
        } else if (text2.equals(MESSAGE25)) {
            textView.setText(MESSAGE1);
        }


    }

}//end class Calendar
