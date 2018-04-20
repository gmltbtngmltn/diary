package edu.android.diary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textview);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Animation.class);
                startActivity(intent);



            }
        });
    }

    public void gotosetting(View view) {
         Intent intent = new Intent(MainActivity.this, DiarySetting.class);
         startActivity(intent);


    }


    public void goToCalendar(View view) {
        Intent intent = new Intent(MainActivity.this,Calendar.class);
        startActivity(intent);
    }
}
