package edu.android.diary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static edu.android.diary.Tab3Text.KEY_DIARY;
import static edu.android.diary.Tab3Text.KEY_TITLE;

public class SamplePage2 extends AppCompatActivity {
    TextView textDate1;
    EditText editTitle2, editText2;
    Button btnSave2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_page2);
        editTitle2 = findViewById(R.id.editSample2Title);
        editText2 = findViewById(R.id.editSample2Diary);
        textDate1 = findViewById(R.id.textDateSample2);
        btnSave2 = findViewById(R.id.btnSample2Save);


        //Tab2Image에서 불러온 것들을 표시
        Intent intent = getIntent();
        String msgt = intent.getStringExtra(KEY_TITLE);
        final String msgd = intent.getStringExtra(KEY_DIARY);


        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd.E", Locale.ENGLISH);
        textDate1.setText(format.format(calendar.getTime()));

        editTitle2.setText(msgt);
        editText2.setText(msgd);

        //그리고 외부저장소에 저장
        btnSave2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DiaryDao.getInstance().writeDiary(1,null,null,msgd);
            }
        });

        }
}
