package edu.android.diary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NoteSlist extends AppCompatActivity {

    private TextView contentSee, finalDaySee;

    private String content, finalDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_slist);

        contentSee = findViewById(R.id.contentSee);
        finalDaySee = findViewById(R.id.finalDaySee);

//        Intent intent = getIntent();
//        content = intent.putExtra(CONTENTINPUTT);
//        finalDay = intent.putExtra(FINALDAYINPUTT);

//        Intent intent = getIntent();
//        year = intent.getIntExtra(SELECTED_YEAR, 1);
//        month = intent.getIntExtra(SELECTED_MONTH, 1);
//        day = intent.getIntExtra(SELECTED_DAY, 1);
//        comm=intent.getIntExtra(COMM,0);
////        String searchDay = year + "년 " + month + "월 " + day + "일";
//        Log.i("aaaa","comm = "+comm);
//        textView.setText(year + "년 " + month + "월 " + day + "일");
//        //contentSee.getText();
    }

}
