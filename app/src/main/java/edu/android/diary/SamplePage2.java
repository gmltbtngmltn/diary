package edu.android.diary;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static edu.android.diary.Tab2Image.KEY_MSG;
import static edu.android.diary.Tab2Image.KEY_URI;
import static edu.android.diary.Tab3Text.KEY_DIARY;
import static edu.android.diary.Tab3Text.KEY_TITLE;

public class SamplePage2 extends AppCompatActivity {
    TextView textDate1;
    EditText editTitle2, editText2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_page2);
        editTitle2 = findViewById(R.id.editSample2Title);
        editText2 = findViewById(R.id.editSample2Diary);
        textDate1 = findViewById(R.id.textDateSample2);
        //TODO : 버튼 찾기

        /*작성한 일기와 이미지 불러오는 부분*/
        Intent intent = getIntent();
        String msg = intent.getStringExtra(KEY_TITLE);
        String msg2 = intent.getStringExtra(KEY_DIARY);


        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd.E", Locale.ENGLISH);
        textDate1.setText(format.format(calendar.getTime()));


        editTitle2.setText(msg);
        editText2.setText(msg2);


    }
}
