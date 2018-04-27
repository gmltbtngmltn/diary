package edu.android.diary;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class TabClockMain extends Fragment {

    public static final String KEY_CLOCK = "KEY_MSG";

     TabClockMain tab1Clock;
     TextView textTitle, textDay;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1_diary_clock_view, container, false);

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
