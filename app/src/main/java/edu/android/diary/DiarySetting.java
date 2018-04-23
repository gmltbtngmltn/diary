package edu.android.diary;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.tsengvn.typekit.Typekit;


public class DiarySetting extends AppCompatActivity {


    private TextView textView1 , textView2 , textView3 ,textView4 , settingTitle , testText;
    private RadioGroup RadioGroup1,RadioGroup2,RadioGroup3;
    private RadioButton btn0,btn1,btn2,btn3,btn4,btn5,btn6;
    private Spinner spinner;
    private Button saveBtn,cancelBtn,backupBtn;
    private Typekit typekit;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_setting);


        //textView
        settingTitle = findViewById(R.id.settingTitle);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        testText = findViewById(R.id.testText);

        //RadioGroup
        RadioGroup1 = findViewById(R.id.radioGroup1);
        RadioGroup2 = findViewById(R.id.radioGroup2);
        RadioGroup3 = findViewById(R.id.radioGroup3);

        //RadioButton
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);

        //Spinner
        spinner = findViewById(R.id.spinner);

        //Button
        saveBtn = findViewById(R.id.saveBtn);
        cancelBtn = findViewById(R.id.cancelBtn);









    }


    public void settingSave(View view) {
         int id = RadioGroup1.getCheckedRadioButtonId();
         RadioButton cRb = findViewById(id);
         if(id == 1){
            Typeface tf = Typeface.createFromAsset(getAssets(),"SangSangTitle.ttf");
            testText.setTypeface(tf);

         }


        Toast.makeText(this, "환경 설정 저장", Toast.LENGTH_SHORT).show();
    }
}
