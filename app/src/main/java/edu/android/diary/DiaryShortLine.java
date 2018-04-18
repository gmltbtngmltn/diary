package edu.android.diary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class DiaryShortLine extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_short_line);

        EditText threeLineText = findViewById(R.id.threeLineText);
        Button btnDone = findViewById(R.id.btndone);


    }
}
