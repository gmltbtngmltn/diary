package edu.android.diary;

import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class Tab2Image extends Fragment{

    ImageView imageTab2;
    ProgressBar progressTab2;
    EditText editTab2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2_diary_image, container, false);

        imageTab2 = rootView.findViewById(R.id.tab2ImageView);
        progressTab2 = rootView.findViewById(R.id.tab2Progress);
        editTab2 = rootView.findViewById(R.id.editTab2);

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        progressTab2.setMax(150);
        progressTab2.setProgress(0);

    }
}
