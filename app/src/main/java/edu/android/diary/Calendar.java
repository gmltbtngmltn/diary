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

//
//    public static final String[] MESSAGES = {
//            "사랑받고 싶다면 사랑하라, 그리고 사랑스럽게 행동하라 -벤자민 프랭클린",
//            "정성과 마음을 다하고 생각이 깊은 사람일수록 상대방에게 정성과 진실한 마음을 더욱더 발견하게 된다\n" + "-톨스토이",
//            "누구도 지신이 받은 것으로 인해 존경받지 않는다\n" + "존경은 자신이 베푼 것에 대한 보답이다\n" + "-캘빈 쿨리지",
//            "가장 어두운 시간은 해뜨기 바로 직전의 시간이다\n" + "-파울로 코엘료",
//            "자기 자신을 희생하는 것처럼 행복한 일은 없다\n" + "-도스토예프스키",
//            "어제는 과거이고, 내일은 미래이고 그리고 오늘은 선물입니다\n" + "그래서 오늘은 현재(present=선물)라고 불립니다\n" + "-빌 킨",
//            "아이들에게 꾸지람보다는 좋은 본보기가 더 절실하게 필요하다\n" + "-주베르",
//            "부모란 자녀에게 사소한 어떤 것을 줘서 아이가 행복하도록 만들어주는 존재이다\n" + "-오그든 내시",
//            "나는 항상 항상 나의 밖에서 강점과 자신감을 찾았지만,\n" + "그것은 내 안에서 나오는 것이다.\n" + "그것은 항상 거기에 있다\n" + "-안나 프로이드",
//            "믿음이 있는 사람에게는 어떠한 설명도 필요 없다\n" + "믿음이 없는 이에게는 어떠한 설명도 불가능하다\n" + "-토마스 아퀴나스",
//            "당신이 몇 살이든, 어떤 환경에서 자랐든,\n" + "어떤 교육을 받았든, 당신의 대부분을 이루고 있는 것은\n" + "개발되지 않는 잠재력이다\n" + "-조지 레오나르드",
//            "자신을 한계 짓지 말라\n" + "많은 이들이 자신이 할 수 있는 것에 대해 한계를 정한다\n" + "당신은 당신의 마음이 정하는 만큼 갈 수 있다\n" + "당신이 믿는 것, 당신은 그것을 성취할 수 있다\n" + "-메리 케이 애시",
//            "지혜는 그 어떤 재산보다 더 중요하다\n" + "-소포클레스",
//            "자신에 대해 긍정적인 생각을 하는 방법은\n" + "긍정적인 행동을 하는 것이다\n" + "사람들은 생각한 대로 살지 않으면 사는 대로 생각한다\n" + "-폴 발레리",
//            "내 경험으로는 항상'그저 어린애'와 함께하는 것이 '그저 어른'과 함께하는\n" + "것보다 훨씬 더 나았기 대문에 '그저 어린애'라는 말을 문제삼을 수 밖에 없다\n" + "-프란 레보비츠",
//            "정말 위대하고 감동적인 모든 것은 자유 안에서 일할 수 있는 것들에 의해 창조된다\n" + "-알버트 아인슈타인",
//            "전쟁에서 이기기란 지진을 이기는 것과 마찬가지다\n" + "-재닛 랜킨",
//            "바로 지금 여기 앉아 아픔과 기쁨을 느끼는 우리의 신체야 말로 우리가 온전한 인간이 되고 완전히\n" + "깨어 완전히 살기 위해 필요한 바로 그것 임을 깨닫는 것 역시 도움이 된다\n" + "-페마 코드론",
//            "(기억이란)인간의 진정한 재산이다, 기억 속의 인간은 가장 부유하면서 또 가장 빈곤하다\n" + "-알렉산더 스미스",
//            "웃음은 두 사람간의 가장 가까운 거리이다\n" + "-빅터 보르게",
//            "우리는 다른 사람이 욕심을 낼 때 겁을 내려고 하고, 다른 사람이 겁을 낼 때만 욕심을 부리곤 한다\n" + "-워런 버펏",
//            "중요한 것은 사랑을 받는 것이 아니라 사랑을 하는 것이었다.\n" + "-월리엄 서머셋 모옴",
//            "한 사람이 다른 한 사람을 사랑하는 것. 이는 모든 일 중 가장 어려운 일이고, 궁극적인\n" + "최후의 시험이자 증명이며, 그 외 모든 일은 이를 위한 준비일 뿐이다.\n" + "-라이너 마리아 릴케",
//            "부자가 되려면 부자들과 어울려 살아가는 끔찍함을 견뎌야 한다\n" + "-로건 피어설 스미스",
//            "명확한 목표는 말의 곁눈 가리개처럼 목표를 가진 이의 시야를 좁게 하기 마련이다\n" + "-로버트 프로스트"
//    };
//
//    private TextView dateDiary, script, textView;
//    private ImageView images;
//    private Dialog myDialog;
//    private Button btnCalendar, nextMot, next, prev;
//    private int CURRENT_INDEX; // 이미지
//    private ImageView imageView; // 이미지
//
//    private int[] IMAGE_RESOURCE_IDS = {
//            R.drawable.mot1, R.drawable.mot2, R.drawable.mot3, R.drawable.mot4,
//            R.drawable.mot5, R.drawable.mot6, R.drawable.mot7, R.drawable.mot8,
//            R.drawable.mot9, R.drawable.mot10, R.drawable.mot11, R.drawable.mot12,
//            R.drawable.mot13, R.drawable.mot14, R.drawable.mot15, R.drawable.mot16,
//            R.drawable.mot17, R.drawable.mot18, R.drawable.mot19, R.drawable.mot20,
//            R.drawable.mot21, R.drawable.mot22, R.drawable.mot23, R.drawable.mot24,
//            R.drawable.mot25
//    };
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_calendar);
//
//        dateDiary = findViewById(R.id.dateOfDiary);
//        btnCalendar = findViewById(R.id.btnCalendar);
//
//        imageView = findViewById(R.id.image1);
//        imageView.setImageResource(IMAGE_RESOURCE_IDS[0]);
//
//        next = findViewById(R.id.next);
//        prev = findViewById(R.id.prev);
//        textView = findViewById(R.id.script);
//        Date d = new Date();
//        SimpleDateFormat simple = new SimpleDateFormat("yyyy년MM월dd일");
//        dateDiary.setText(simple.format(d));
//        myDialog = new Dialog(this);
//
////        next.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                String text = next.getText().toString();
////                if (text.equals(MESSAGE1)) {
////                    next.setText(MESSAGE2);
////                } else if (text.equals(MESSAGE25)) {
////                    next.setText(MESSAGE1);
////                }
////            }//end onClick
////        });
////        prev.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                String text2 = prev.getText().toString();
////                if (text2.equals(MESSAGE1)) {
////                    prev.setText(MESSAGE2);
////                } else if (text2.equals(MESSAGE25)) {
////                    prev.setText(MESSAGE1);
////                }
////            }//end onClick
////        });
//
////        textvView();
//
//
//        btnCalendar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showPopup(v);
//            }
//        });
//        //todo: 데이터베이스에서 날짜 카운팅후 갯수만큼 프레그레스바 에 적용때리기.
//
//
//    }
//
//    public void showPopup(View v) {
//        CalendarView calendarView;
//        TextView closeView;
//        myDialog.setContentView(R.layout.popupcalendar);
//        closeView = (TextView) myDialog.findViewById(R.id.closeView);
//        closeView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                myDialog.dismiss();
//            }
//        });
//
//        myDialog.show();
//
//        //todo: 일기를 쓴 날짜에 표시되는 기능 필요. 머테리얼캘린더뷰 이용.
//        //todo: 데이터베이스에서 검색 , 조건문써서 날짜표시
//
//    }
//
//
//    public void onClickNext(View view) {
//
//        if (++CURRENT_INDEX > 24) {
//            Toast toast = Toast.makeText(this, "마지막 명언 입니다.", Toast.LENGTH_SHORT);
//            toast.show();
//
//            CURRENT_INDEX--;
//        } else {
//
//        }
//
//
//    }
//
//    public void onClickPrev(View view) {
//
//
//        if (--CURRENT_INDEX < 0) {
//            Toast toast = Toast.makeText(this, "처음 명언 입니다.", Toast.LENGTH_SHORT);
//            toast.show();
//
//            CURRENT_INDEX++;
//        } else {
//            // TODO:
//        }
//
//
//    }

}//end class Calendar
