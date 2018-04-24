package edu.android.diary;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class Tab1Clock extends Fragment {

     Tab1Clock tab1Clock;
     TextView textTitle, textDay;
     private  String[] monthText = {"1月 새로운 시작, 새로운 마음",
             "2月, 겨울의 끝자락, 새로운 시작 ", "3月 봄의 알림","4月 수줍게 보이는 꽃들",
             "5月 가족과 함께 ","6月 여름의 알림","7月 아이스크림 먹고 싶지 않아?",
             "8月 더운데 고생했어:)","9月 하늘은 높고 내 배는 옆으로 커지고",
             "10月 붉은 비가 내리네~", "11月 뭐 했다고 벌써 11월이지?","12月 남의 생일이지만 놀자! +\n 이제 곧 +1살 이라니.."

     };






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1_diary_clock, container, false);

        rootView.findViewById(R.id.clockView);
        textTitle = rootView.findViewById(R.id.clockTitleTab1);
        textDay = rootView.findViewById(R.id.clockDayTab1);



        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd.E", Locale.ENGLISH);
        textDay.setText(format.format(calendar.getTime()));

        /**
         * 각 달마다 다른 문구가 뜨도록 설정
         */
        int month = calendar.get(Calendar.MONTH);
        String[] messages = getActivity().getResources().getStringArray(R.array.monthT);
        textTitle.setText(messages[month]);

//        int monthT = 0;
//     if (String.format("MM").equals(04)){
//         textTitle.setText(monthText[0]);
//     }

    }



}
