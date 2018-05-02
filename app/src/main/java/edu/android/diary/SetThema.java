package edu.android.diary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class SetThema extends AppCompatActivity {
    public static final String AAA = "AAA";
    private ImageView imageth1,imageth2,imageth3,imageth4;
    private int comm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_thema);

        imageth1 = findViewById(R.id.imagetth1);
        imageth1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comm=1;
                savethemenum();
                goback();
            }
        });

        imageth2 = findViewById(R.id.imagetth2);
        imageth2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comm=2;
                savethemenum();
                goback();
            }
        });

        imageth3 = findViewById(R.id.imagetth3);
        imageth3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comm=3;
                savethemenum();
                goback();
            }
        });

        imageth4 = findViewById(R.id.imagetth4);
        imageth4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comm=4;
                savethemenum();
                goback();
            }
        });



    }

    public void savethemenum(){
        DiaryDao.getInstance().saveThemeNum(comm);
    }

    public void goback(){
        Intent data = new Intent();
        data.putExtra(AAA,comm);
        Log.i("aaaa"," sthmm = "+comm);
        setResult(RESULT_OK, data);
        Log.i("aaaa"," sthmm222 = "+comm);
        finish();
    }
}
