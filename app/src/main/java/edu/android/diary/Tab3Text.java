package edu.android.diary;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Tab3Text extends Fragment{

    EditText editTitle, editText;
    Button btnTab3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab3_diary_text, container, false);

        editText = rootView.findViewById(R.id.editTab3Title);
        editText = rootView.findViewById(R.id.editTab3Diary);
        btnTab3 = rootView.findViewById(R.id.tab3Btn);

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}
