package edu.android.diary;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import static android.provider.Contacts.SettingsColumns.KEY;

public class DetailText extends AppCompatActivity {
    public static final String KEY_URI = "key_img";
    public static final String KEY_TIT = "key_tit";
    public static final String KEY_MSG = "key_msg";

    ImageView imageView;
    Button btnDone, btnPrev;
    EditText editText;
    Diary diary;
    public static Intent newIntent(Context context, int positoin){
        Intent intent=new Intent(context,DetailText.class);
        intent.putExtra(KEY,positoin);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_text);

        imageView = findViewById(R.id.imageDetail);
        editText = findViewById(R.id.editTextDetail);
        btnPrev = findViewById(R.id.btnDetailRe);//수정
        btnDone = findViewById(R.id.btnDetailDone);

        editText.setFocusable(false);
        editText.setClickable(false);

        Intent intent=getIntent();

        final int index=intent.getIntExtra(KEY,0);

        diary=DiaryDao.getInstance().getContactList().get(index);


        Bitmap bitmap=DiaryDao.getInstance().LoadImage(diary.getPhotoPath());
        imageView.setImageBitmap(bitmap);

        editText.setText(diary.getTxt());

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
                intent.putExtra(KEY_URI,diary.getPhotoPath());
                intent.putExtra(KEY_TIT,diary.getTitle());
                intent.putExtra(KEY_MSG,diary.getTxt());
                startActivity(intent);
                finish();
            }
        });


    }
}
