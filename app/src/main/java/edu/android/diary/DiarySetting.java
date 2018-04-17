package edu.android.diary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class DiarySetting extends AppCompatActivity {


    public static final String [] themes = {"theme1" , "theme2" , "theme3" , "theme4" , "theme5",
            "theme6"};
    private TextView textView1 , textView2 , textView3 ,textView4 , settingTitle;
    private RadioGroup RadioGroup1,RadioGroup2,RadioGroup3;
    private RadioButton btn1,btn2,btn3,btn4,btn5,btn6;
    private Spinner spinner;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_setting);





    }
}
