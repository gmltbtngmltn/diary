package edu.android.diary;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static edu.android.diary.Tab1Clock.KEY_CLOCK;
import static edu.android.diary.Tab2Image.KEY_MSG;
import static edu.android.diary.Tab2Image.KEY_URI;

public class SamplePage extends AppCompatActivity {

    private TextView textDate;
    private EditText editText;
    private ImageView imageView;
    private Button btnSave1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_page);

        editText = findViewById(R.id.editSample);
        imageView = findViewById(R.id.imageSample);
        textDate = findViewById(R.id.textSampleDate);
        btnSave1 = findViewById(R.id.btnSampleSave);
//        editText.setFocusable(false);
//        editText.setClickable(false);

        /*버튼 누르면 더미 데이터에 저장*/
        btnSave1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();

//                Uri uri = imageView.setImageBitmap();

                try {
                    FileOutputStream fos = openFileOutput
                            ("myDiary.txt", // 파일명 지정
                                    Context.MODE_APPEND);// 저장모드
                    PrintWriter out = new PrintWriter(fos);
                    out.println(text);
                    out.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }




            }
        });



         /*작성한 일기와 이미지 불러오는 부분*/
        Intent intent = getIntent();
        String msg = intent.getStringExtra(KEY_MSG);
        Uri uri = intent.getParcelableExtra(KEY_URI);

        editText.setText(msg);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd.E", Locale.ENGLISH);
        textDate.setText(format.format(calendar.getTime()));


        try {

            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
            imageView.setImageBitmap(bitmap);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }




}
