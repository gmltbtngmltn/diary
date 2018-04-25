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


import static edu.android.diary.Tab2Image.KEY_MSG;
import static edu.android.diary.Tab2Image.KEY_URI;
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
//        editText.setFocusable(false);
//        editText.setClickable(false);

        /*버튼 누르면 더미 데이터에 저장*/
        btnSave1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 저장 디렉토리
                File saveDirectory = new File(Environment.getExternalStorageDirectory(), DIARY_DIRECTORY);

                // 저장할 파일
                SimpleDateFormat sdf = new SimpleDateFormat("_yyyyMMdd_HHmmss");
                String timestamp = sdf.format(new Date());
                String fileName = DIARY_FILE_NAME + timestamp;

                File saveFile = new File(saveDirectory, fileName);
                FileOutputStream out = null;
                OutputStreamWriter writer = null;
                BufferedWriter bw = null;
                try {
                    out = new FileOutputStream(saveFile);
                    writer = new OutputStreamWriter(out);
                    bw = new BufferedWriter(writer);

                    bw.write(editText.getText().toString());
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
/*
                String dirPath = getFilesDir().getAbsolutePath();
                File file = new File(dirPath);

                // 일치하는 폴더가 없으면 생성
                if (!file.exists()) {
                    file.mkdirs();
                    Toast.makeText(SamplePage.this, "Folder Success", Toast.LENGTH_SHORT).show();
                }

                // txt 파일 생성
                String testStr = textDate + "txt";
                File savefile = new File(dirPath + "/test.txt");
                try {
                    FileOutputStream fos = new FileOutputStream(savefile);
                    fos.write(testStr.getBytes());
                    fos.close();
                    Toast.makeText(SamplePage.this, "Save Success", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                }

                // 파일이 1개 이상이면 파일 이름 출력
                if (file.listFiles().length > 0)
                    for (File f : file.listFiles()) {
                        String str = f.getName();
                        Log.v(null, "fileName : " + str);

                        // 파일 내용 읽어오기
                        String loadPath = dirPath + "/" + str;
                        try {
                            FileInputStream fis = new FileInputStream(loadPath);
                            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(fis));

                            String content = "", temp = "";
                            while ((temp = bufferReader.readLine()) != null) {
                                content += temp;
                            }
                            Log.v(null, "" + content);
                        } catch (Exception e) {
                        }
                    }
*/

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
