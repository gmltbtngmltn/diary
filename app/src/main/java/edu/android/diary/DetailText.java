package edu.android.diary;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
//import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.github.clans.fab.FloatingActionMenu;
import com.github.clans.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import static edu.android.diary.Animation.*;
import static android.provider.Contacts.SettingsColumns.KEY;
import static edu.android.diary.DiaryList_FragmentViewpager.KEY_ARR;

public class DetailText extends AppCompatActivity {
    public static final String KEY_URI = "key_img";
    public static final String KEY_TIT = "key_tit";
    public static final String KEY_MSG = "key_msg";


    FloatingActionMenu fam;
    FloatingActionButton fabPrev, fabDone;
    private ImageView imageView;
    private TextView textTitle, textText;
    private int position;

    private List<Diary> dataset;
    private Diary diary;
    public static Intent newIntent(Context context, int positoin){
        Intent intent=new Intent(context,DetailText.class);
        intent.putExtra(KEY,positoin);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_text);

        //findViewById
        imageView = findViewById(R.id.imageDetail);
        textTitle = findViewById(R.id.textDetailTitle);
        textText = findViewById(R.id.textDetailText);
        fam =  findViewById(R.id.floatingActionMenu);
        fabDone =findViewById(R.id.btnDoneFab);
        fabPrev =  findViewById(R.id.btnPrevFab);

        fabPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailText.this, Recorde.class);
                            //TODO : 기록보는 페이지에서 일기를 누르면 이미지값과 텍스트값 받아오기
                            intent.putExtra(KEY_URI,diary.getPhotoPath());
                            intent.putExtra(KEY_TIT,diary.getTitle());
                            intent.putExtra(KEY_MSG,diary.getTxt());
                            intent.putExtra(QUE,1);//수정하러갈때 명령값은 1으로한다

                            intent.putExtra(KEY,position);
                            startActivity(intent);
                            finish();
            }
        });

        fabDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        Intent intent=getIntent();

        position=intent.getIntExtra(KEY,0);

        dataset = (ArrayList<Diary>) getIntent().getSerializableExtra(KEY_ARR);

        diary=dataset.get(position);

        
        Bitmap bitmap=DiaryDao.getInstance().LoadImage(diary.getPhotoPath());
        imageView.setImageBitmap(bitmap);

        //TODO:제목과 내용 따로 불러 올 수 있게 바꿔주세요
        textTitle.setText(diary.getTitle());
        textText.setText(diary.getTxt());





    }

//    private void viewShowMenu() {
//
//        if(!isOpen){
////            int x = laydoutContent.getRight();
////            int y = laydoutContent.getBottom();
//            int x = layoutMain.getRight();
//            int y = layoutMain.getBottom();
//
//            int startRadius = 0;
//            int endRadius =(int) Math.hypot(layoutMain.getWidth(), layoutMain.getHeight());
//
//            fab.setBackgroundTintList(ColorStateList.
//                    valueOf(ResourcesCompat.getColor(getResources(),
//                            android.R.color.holo_blue_light,
//                            null)));
//            fab.setImageResource(R.drawable.fab1);
//
//            Animator ani = ViewAnimationUtils.createCircularReveal(
//                    layoutButton, x, y, startRadius, endRadius);
//
//
//            layoutButton.setVisibility(View.VISIBLE);
//            ani.start();
//
//            isOpen = true;
//
//        }else{
////            int x = laydoutContent.getRight();
////            int y = laydoutContent.getBottom();
//            int x = layoutMain.getRight();
//            int y = layoutMain.getBottom();
//
////            int startRadius = Math.max(laydoutContent.getWidth(), laydoutContent.getHeight());
////            int endRadius =0;
//            int startRadius = Math.max(layoutMain.getWidth(), layoutMain.getHeight());
//            int endRadius = 0;
//
//            fab.setBackgroundTintList(ColorStateList.
//                    valueOf(ResourcesCompat.getColor(getResources(),
//                            android.R.color.holo_blue_bright,
//                            null)));
//            fab.setImageResource(R.drawable.fab1);
//
//            Animator ani = ViewAnimationUtils.createCircularReveal(
//                    layoutButton, x, y, startRadius, endRadius);
//            ani.addListener(new Animator.AnimatorListener() {
//                @Override
//                public void onAnimationStart(Animator animation) {
//
//                    Log.i("MainActivity","start");
//
//
//                }
//
//                @Override
//                public void onAnimationEnd(Animator animation) {
//                    layoutButton.setVisibility(View.GONE);
//                    Log.i("MainActivity","end");
//                }
//
//                @Override
//                public void onAnimationCancel(Animator animation) {
//                    Log.i("MainActivity","cancle");
//
//
//
//
//                }
//
//                @Override
//                public void onAnimationRepeat(Animator animation) {
//                    Log.i("MainActivity","repeat");
//                    btnDone.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//
//                            finish();
//                        }
//                    });
//
//                    btnPrev.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            Intent intent = new Intent(DetailText.this, Recorde.class);
//                            //TODO : 기록보는 페이지에서 일기를 누르면 이미지값과 텍스트값 받아오기
//                            intent.putExtra(KEY_URI,diary.getPhotoPath());
//                            intent.putExtra(KEY_TIT,diary.getTitle());
//                            intent.putExtra(KEY_MSG,diary.getTxt());
//                            startActivity(intent);
//                            finish();
//                        }
//                    });
//                }
//            });
//
//            ani.start();
//            isOpen= false;
//
//
//        }

    }



