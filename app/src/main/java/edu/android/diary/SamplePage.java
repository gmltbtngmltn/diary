package edu.android.diary;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.UrlQuerySanitizer;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


import static edu.android.diary.Tab2Image.*;
import static edu.android.diary.MainActivity.TAG;
import static edu.android.diary.MainActivity.DIARY_DIRECTORY;


public class SamplePage extends AppCompatActivity {
    public static final String DIARY_FILE_NAME = "diary";

    private TextView textDate;
    private EditText editText;
    private ImageView imageView;
    private Button btnSave1;
    private File file;
    private Context context;
    private URL url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_page);

        editText = findViewById(R.id.editSample);
        imageView = findViewById(R.id.imageSample);
        textDate = findViewById(R.id.textSampleDate);
        btnSave1 = findViewById(R.id.btnSampleSave);

        //Tab2Image에서 불러온 것들
        Intent intent = getIntent();
        final String msg = intent.getStringExtra(KEY_MSG);
        final String imgname=intent.getStringExtra(KEY_IMGNAME);
        final Bitmap bitmap = intent.getParcelableExtra(KEY_IMG);

        //Tab2Image에서 불러온 것들을 표시
        editText.setText(msg);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd.E", Locale.ENGLISH);
        textDate.setText(format.format(calendar.getTime()));

        try {
            imageView.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //그리고 외부저장소에 저장
        btnSave1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DiaryDao.getInstance().writeDiary(0,bitmap,imgname,msg);
            }
        });




    }


}
