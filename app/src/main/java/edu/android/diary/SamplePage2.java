package edu.android.diary;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static edu.android.diary.MainActivity.DIARY_DIRECTORY;
import static edu.android.diary.MainActivity.TAG;
import static edu.android.diary.Tab2Image.KEY_MSG;
import static edu.android.diary.Tab2Image.KEY_URI;
import static edu.android.diary.Tab3Text.KEY_DIARY;
import static edu.android.diary.Tab3Text.KEY_TITLE;

public class SamplePage2 extends AppCompatActivity {
    public static final String DIARY_FILE_NAME_2 = "diary2";

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


        /*작성한 일기 불러오는 부분*/
        Intent intent = getIntent();
        String msg = intent.getStringExtra(KEY_TITLE);
        String msg2 = intent.getStringExtra(KEY_DIARY);


        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd.E", Locale.ENGLISH);
        textDate1.setText(format.format(calendar.getTime()));

        editTitle2.setText(msg);
        editText2.setText(msg2);

        //파일 저장 하는 부분
        btnSave2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 저장 디렉토리
                File saveDirectory = new File(Environment.getExternalStorageDirectory(), DIARY_DIRECTORY);

                // 저장할 파일
                SimpleDateFormat sdf = new SimpleDateFormat("_yyyyMMdd_HHmmss");
                String timestamp = sdf.format(new Date());
                String fileName = DIARY_FILE_NAME_2 + timestamp;

                File saveFile = new File(saveDirectory, fileName);
                FileOutputStream out = null;
                OutputStreamWriter writer = null;
                BufferedWriter bw = null;
                try {
                    out = new FileOutputStream(saveFile);
                    writer = new OutputStreamWriter(out);
                    bw = new BufferedWriter(writer);

                    bw.write("Title"+editTitle2.getText().toString() + "\n" + editText2.getText().toString());
                    Log.i(TAG, "파일 생성됨");
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e(TAG, "파일 생성 실패");
                } finally {
                    try {
                        bw.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        }
}
