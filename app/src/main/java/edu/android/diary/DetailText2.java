//package edu.android.diary;
//
//import android.animation.Animator;
//import android.content.Context;
//import android.content.Intent;
//import android.content.res.ColorStateList;
//import android.graphics.Bitmap;
//import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.v4.app.ActivityOptionsCompat;
//import android.support.v4.content.res.ResourcesCompat;
//import android.support.v4.view.ViewCompat;
//import android.support.v7.app.AppCompatActivity;
//import android.transition.Fade;
//import android.view.View;
//import android.view.ViewAnimationUtils;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//
//import static android.provider.Contacts.SettingsColumns.KEY;
//
//public class DetailText2 extends AppCompatActivity {
//
//
//    private FloatingActionButton fab;
//    private RelativeLayout layoutMain;
//    private RelativeLayout layoutButton;
//    private RelativeLayout laydoutContent;
//    private  boolean isOpen = false;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_detail_text);
//        layoutMain = findViewById(R.id.layoutMainD);
//        layoutButton= findViewById(R.id.layoutButtonD);
//        laydoutContent = findViewById(R.id.layoutContentD);
//
//        fab = findViewById(R.id.fabDetailText);
//
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewMenu();
//            }
//        });
//
//        Fade fade = new Fade();
//        View decor = getWindow().getDecorView();
//        fade.excludeTarget(decor.findViewById(R.id.action_bar_container),true);
//        fade.excludeTarget(android.R.id.statusBarBackground,true);
//        fade.excludeTarget(android.R.id.navigationBarBackground,true);
//
//        getWindow().setEnterTransition(fade);
//        getWindow().setExitTransition(fade);
//
//
//    }
//
//    private void viewMenu() {
//        if(!isOpen){
//            int x = laydoutContent.getRight();
//            int y = laydoutContent.getBottom();
//
//            int startRadius = 0;
//            int endRadius =(int) Math.hypot(layoutMain.getWidth(), layoutMain.getHeight());
//
//            fab.setBackgroundTintList(ColorStateList.
//                    valueOf(ResourcesCompat.getColor(getResources(),
//                            android.R.color.white,
//                            null)));
//            fab.setImageResource(R.drawable.ic_launcher_background);
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
//            int x = laydoutContent.getRight();
//            int y = laydoutContent.getBottom();
//
//            int startRadius = Math.max(laydoutContent.getWidth(), laydoutContent.getHeight());
//            int endRadius =0;
//
//            fab.setBackgroundTintList(ColorStateList.
//                    valueOf(ResourcesCompat.getColor(getResources(),
//                            android.R.color.holo_blue_light,
//                            null)));
//            fab.setImageResource(R.drawable.ic_launcher_background);
//
//            Animator ani = ViewAnimationUtils.createCircularReveal(
//                    layoutButton, x, y, startRadius, endRadius);
//            ani.addListener(new Animator.AnimatorListener() {
//                @Override
//                public void onAnimationStart(Animator animation) {
//
//                }
//
//                @Override
//                public void onAnimationEnd(Animator animation) {
//                    layoutButton.setVisibility(View.GONE);
//
//                }
//
//                @Override
//                public void onAnimationCancel(Animator animation) {
//
//                }
//
//                @Override
//                public void onAnimationRepeat(Animator animation) {
//
//                }
//            });
//
//            ani.start();
//            isOpen= false;
//
//
//        }
//
//    }
//
//
//}
