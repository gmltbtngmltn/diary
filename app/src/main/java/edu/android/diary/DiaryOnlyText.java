package edu.android.diary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DiaryOnlyText extends AppCompatActivity {

    TextView textView;
    EditText editTitle, editRecorde;
    Spinner spinner;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_only_text);

        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.E");
        String dateString = sdf.format(date);

        TextView tDate = findViewById(R.id.textDate);
        tDate.setText(dateString);




    }


}
