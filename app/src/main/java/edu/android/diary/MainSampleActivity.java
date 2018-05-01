package edu.android.diary;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static android.provider.Contacts.SettingsColumns.KEY;

public class MainSampleActivity extends AppCompatActivity {
    public static Intent newIntent(Context context, int positoin){
        Intent intent=new Intent(context,DirayDetailActivity.class);
        intent.putExtra(KEY,positoin);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sample);

        Fade fade = new Fade();
        View decor = getWindow().getDecorView();
        fade.excludeTarget(decor.findViewById(R.id.action_bar_container),true);
        fade.excludeTarget(android.R.id.statusBarBackground,true);
        fade.excludeTarget(android.R.id.navigationBarBackground,true);

        getWindow().setEnterTransition(fade);
        getWindow().setExitTransition(fade);


        final ImageView imageView = findViewById(R.id.imageSampleD);
        TextView textView = findViewById(R.id.textSampleD);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainSampleActivity.this,ScrollingDetailDiary.class);
                ActivityOptionsCompat optionsCompat =
                        ActivityOptionsCompat.makeSceneTransitionAnimation(MainSampleActivity.this,
                                imageView,
                                ViewCompat.getTransitionName(imageView));

                startActivity(intent,optionsCompat.toBundle());
            }
        });


        /*-------------------------------------------*/
        findViewById(R.id.imageSampleD).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainSampleActivity.this, ScrollingDetailDiary.class);

                Pair<View, String> pair =
                        Pair.create(findViewById(R.id.imageSampleD),"myImage");

                Pair<View, String> pair2 =
                        Pair.create(findViewById(R.id.textSampleD),"myText");


                ActivityOptionsCompat aoc =
                        ActivityOptionsCompat.makeSceneTransitionAnimation(MainSampleActivity.this, pair, pair2);

                startActivity(intent, aoc.toBundle());
            }
        });


    }
}
