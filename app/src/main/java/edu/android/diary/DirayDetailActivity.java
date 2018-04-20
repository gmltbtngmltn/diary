package edu.android.diary;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import static android.provider.Contacts.SettingsColumns.KEY;

public class DirayDetailActivity extends AppCompatActivity {
    public static Intent newIntent(Context context, int positoin){
        Intent intent=new Intent(context,DirayDetailActivity.class);
        intent.putExtra(KEY,positoin);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diray_detail);
        Intent intent=getIntent();

        int index=intent.getIntExtra(KEY,0);

        Diary diary=DiaryDao.getInstance().getContactList().get(index);

        ImageView imageView=findViewById(R.id.diaryimageView);
        Bitmap bitmap=DiaryDao.getInstance().LoadImage(diary.getPhotoPath());
        imageView.setImageBitmap(bitmap);

        TextView textView=findViewById(R.id.diarytextView);
        textView.setText(diary.getTxt());
    }
}
