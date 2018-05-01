package edu.android.diary;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static android.provider.Contacts.SettingsColumns.KEY;

public class ScrollingDetailDiary extends AppCompatActivity {
    public static final String KEY_URI = "key_img";
    public static final String KEY_TIT = "key_tit";
    public static final String KEY_MSG = "key_msg";


    private FloatingActionButton fab;
    private CoordinatorLayout layoutMain;
    private RelativeLayout layoutButton2;
    private RelativeLayout layoutContent;
    private  boolean isOpen = false;

    ImageView imageView;
    EditText editText;
    Button btnDone, btnRe;
    Diary diary;
    public static Intent newIntent(Context context, int positoin){
        Intent intent=new Intent(context,DetailText.class);
        intent.putExtra(KEY,positoin);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling_detail_diary);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        editText.setFocusable(false);
//        editText.setClickable(false);

        btnDone = findViewById(R.id.btnTwo);
        btnRe = findViewById(R.id.btnOne);

        Intent intent=getIntent();

        final int index=intent.getIntExtra(KEY,0);

        diary=DiaryDao.getInstance().getContactList().get(index);


        Bitmap bitmap=DiaryDao.getInstance().LoadImage(diary.getPhotoPath());
        //TODO: 오류
        imageView.setImageBitmap(bitmap);

        editText.setText(diary.getTxt());
        btnRe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScrollingDetailDiary.this, Recorde.class);
                //TODO : 기록보는 페이지에서 일기를 누르면 이미지값과 텍스트값 받아오기
                intent.putExtra(KEY_URI,diary.getPhotoPath());
                intent.putExtra(KEY_TIT,diary.getTitle());
                intent.putExtra(KEY_MSG,diary.getTxt());
                startActivity(intent);
                finish();
            }
        });

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


/*+++++++++++++++++++++++++*/
        layoutMain = findViewById(R.id.layoutMain);
        layoutButton2= findViewById(R.id.layoutButton);
        layoutContent = findViewById(R.id.layoutContent);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewMenu();
            }
        });
        /*----------*/


        Fade fade = new Fade();
        View decor = getWindow().getDecorView();
        fade.excludeTarget(decor.findViewById(R.id.action_bar_container),true);
        fade.excludeTarget(android.R.id.statusBarBackground,true);
        fade.excludeTarget(android.R.id.navigationBarBackground,true);

        getWindow().setEnterTransition(fade);
        getWindow().setExitTransition(fade);

    }

    private void viewMenu() {

        if(!isOpen){
            int x = layoutContent.getRight();
            int y = layoutContent.getBottom();

            int startRadius = 0;
            int endRadius =(int) Math.hypot(layoutMain.getWidth(), layoutMain.getHeight());

            fab.setBackgroundTintList(ColorStateList.
                    valueOf(ResourcesCompat.getColor(getResources(),
                            android.R.color.white,
                            null)));
            fab.setImageResource(R.drawable.ic_launcher_background);

            Animator ani = ViewAnimationUtils.createCircularReveal(
                    layoutButton2, x, y, startRadius, endRadius);


            layoutButton2.setVisibility(View.VISIBLE);
            ani.start();

            isOpen = true;

        }else{
            int x = layoutContent.getRight();
            int y = layoutContent.getBottom();

            int startRadius = Math.max(layoutContent.getWidth(), layoutContent.getHeight());
            int endRadius =0;

            fab.setBackgroundTintList(ColorStateList.
                    valueOf(ResourcesCompat.getColor(getResources(),
                            android.R.color.holo_blue_light,
                            null)));
            fab.setImageResource(R.drawable.ic_launcher_background);

            Animator ani = ViewAnimationUtils.createCircularReveal(
                    layoutButton2, x, y, startRadius, endRadius);
            ani.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    layoutButton2.setVisibility(View.GONE);

                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });

            ani.start();
            isOpen= false;


        }
    }
}
