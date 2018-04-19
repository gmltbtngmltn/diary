package edu.android.diary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class DiaryShortLine extends AppCompatActivity {

    private static final String TAG = "DiaryShortLine";
    ProgressBar progressBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_short_line);

        final EditText threeLineText = findViewById(R.id.threeLineText);
        Button btnDone = findViewById(R.id.btndone);

//        // Get the Drawable custom_progressbar
//        Drawable draw = getDrawable(R.drawable.customprograssbar);
//        /* set the drawable as progress drawable */
//
//        progressBar2.setProgressDrawable(draw);

        //TODO : 버튼 누르면 저장 -> 미리보기 화면 넘어가는 기능 만들기

//        InputFilter[] filterArray = new InputFilter[1];
//        filterArray[0] = new InputFilter.LengthFilter(3);
//        threeLineText.setFilters(filterArray);
//        final ProgressBar progressBar = findViewById(R.id.prograssBar2);

//        progressBar.setIndeterminate(true);
//        progressBar2.setMax(100);
//        progressBar2.setProgress(0);

        progressBar2 = findViewById(R.id.progressBar2);
        progressBar2.setMax(100);
        progressBar2.setProgress(0);

        threeLineText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                Log.i(TAG, "count=" + count);
            }

            @Override
            public void afterTextChanged(Editable s) {
                progressBar2.setProgress(s.toString().length());


//                if (s.toString().length() == 10) {
//                    Log.i(TAG, "Max length");
//                    progressBar2.setProgress(100);
////                    progressBar.
//                }
            }
        });


    }
}
