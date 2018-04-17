package edu.android.diary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tsengvn.typekit.Typekit;

public class App extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        Typekit.getInstance().addNormal(Typekit.createFromAsset(this,"fonts/SangSangTitle"));
    }
}
