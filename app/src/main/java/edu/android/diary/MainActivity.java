package edu.android.diary;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.graphics.TypefaceCompatUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    private static final int REQ_CODE_PERMISSION = 1;
    private Button button;

    private void createDirectory() {
        DiaryDao.getInstance().createDir();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Animation.class);
                startActivity(intent);
            }
        });




        //////////초장부터 외부저장소 사용권한 허용하기
        String[] permissions = {
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
        };
        if (hasPermissions(permissions)) {
            // 필요한 권한들이 허용된 경우
            Toast.makeText(this, "권한 허용됨",
                    Toast.LENGTH_LONG).show();
            createDirectory();
        } else {

            ActivityCompat.requestPermissions(this, permissions,
                    REQ_CODE_PERMISSION);
        }
        /////////////외부저장소 사용권한 허용하기

    }





    ////////////////////////외부저장소 사용권한 허용하기
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == REQ_CODE_PERMISSION) {
            // 사용자가 SEND_SMS와 READ_PHONE_STATE 권한을 모두 허용한 경우에만
            // sendSms() 호출
            if (grantResults.length == 2 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                    grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "권한 허용됨",
                        Toast.LENGTH_LONG).show();
                createDirectory();
            } else {
                Toast.makeText(this, "권한을 허용해주세요...",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean hasPermissions(String[] permissions) {
        boolean result = true;
        for (String p : permissions) {
            if (ActivityCompat.checkSelfPermission(this, p)
                    != PackageManager.PERMISSION_GRANTED) {
                result = false;
                break;
            }
        }
        return result;
    }
    ///////////////////////////외부저장소 사용권한 허용하기


}
