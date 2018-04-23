package edu.android.diary;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Tab1Clock extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1_diary_c, container, false);
        Tab1ClockView clockView = rootView.findViewById(R.id.clock);


        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
     

    }

}
