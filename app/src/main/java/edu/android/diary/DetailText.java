package edu.android.diary;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class DetailText extends AppCompatActivity {
    public static final String KEY_URI = "key_img";
    public static final String KEY_MSG = "key_msg";

    ImageView imageView;
    Button btnDone, btnPrev;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_text);

        imageView = findViewById(R.id.imageDetail);
        editText = findViewById(R.id.editTextDetail);
        btnPrev = findViewById(R.id.btnDetailRe);
        btnDone = findViewById(R.id.btnDetailDone);

        editText.setFocusable(false);
        editText.setClickable(false);


        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailText.this, Recorde.class);
                //TODO : 기록보는 페이지에서 일기를 누르면 이미지값과 텍스트값 받아오기


            }
        });


    }
}
