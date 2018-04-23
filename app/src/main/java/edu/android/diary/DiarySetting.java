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


    private TextView textView1, textView2, textView3, textView4, settingTitle, testText;
    private RadioGroup radioGroup1, radioGroup2, radioGroup3;
    private RadioButton btn0, btn1, btn2, btn3, btn4, btn5, btn6;
    private Spinner spinner;
    private Button saveBtn, cancelBtn;



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
        radioGroup1 = findViewById(R.id.radioGroup1);
        radioGroup2 = findViewById(R.id.radioGroup2);
        radioGroup3 = findViewById(R.id.radioGroup3);

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

        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.btn0) {
                    //todo: 기본 글꼴 assets 폴더에 저장후 밑에 코드처럼!
                } else if (checkedId == R.id.btn1) {

                    Typeface tf = Typeface.createFromAsset(getAssets(), "SangSangTitle.ttf");
                    testText.setTypeface(tf);
                } else if (checkedId == R.id.btn2) {

                    Typeface tf = Typeface.createFromAsset(getAssets(), "nanumgothic.ttf");
                    testText.setTypeface(tf);
                }
            }
        });

        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.btn3) {

                    settingTitle.setText("환경 설정");
                    textView1.setText("폰트 변경");
                    textView2.setText("언어 변경(Change Language)");
                    textView3.setText("레이아웃 변경");
                    textView4.setText("테마 변경");
                    saveBtn.setText("적용");
                    cancelBtn.setText("돌아가기");

                    } else if (checkedId == R.id.btn4) {

                    settingTitle.setText("Setting");
                    textView1.setText("Font");
                    textView2.setText("Language");
                    textView3.setText("Layout");
                    textView4.setText("Theme");
                    saveBtn.setText("Apply");
                    cancelBtn.setText("Back");
                    }

            }

            });


    }

    public void apply(View view) {

        Toast.makeText(this,"설정 저장 완료",Toast.LENGTH_SHORT).show();

    }
}