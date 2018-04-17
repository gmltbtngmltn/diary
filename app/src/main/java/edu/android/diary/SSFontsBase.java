package edu.android.diary;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tsengvn.typekit.Typekit;

public class SSFontsBase extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Typekit.getInstance().addNormal(Typekit.createFromAsset(this,"fonts/SangSangTitle.tff"));

    }
}
