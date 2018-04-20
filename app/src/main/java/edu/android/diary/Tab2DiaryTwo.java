package edu.android.diary;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tab2DiaryTwo extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.diarytwo_page2, container, false);

        TextView textView = rootView.findViewById(R.id.tDate);
        EditText editTitle = rootView.findViewById(R.id.editTitle);
        EditText editDiary = rootView.findViewById(R.id.editDiary);
        Button btnTab2 = rootView.findViewById(R.id.btndone);



        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();





    }




}