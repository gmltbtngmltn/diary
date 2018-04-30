package edu.android.diary;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.app.Activity;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import android.util.Log;
import android.view.DragEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.tsengvn.typekit.TypekitContextWrapper;

public class Recorde extends AppCompatActivity {

    Uri selectedImageUri;
    String  selectedPath;
    TextView textDate;
    EditText editTitle, editMain;
    ImageButton btnClose, btnSave;
    ImageView imageView;
    private Bitmap bitmap;
    private String bimapName;

    private File destination = null;
    private InputStream inputStreamImg;
    private String imgPath = null;
    private static final String IMAGE_DIRECTORY = "/myDiary";
    private final int PICK_IMAGE_CAMERA = 1, PICK_IMAGE_GALLERY = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recorde);

        //찾기
        textDate = findViewById(R.id.textDate1);
        editTitle = findViewById(R.id.editMainTitle);
        editMain = findViewById(R.id.editMainText);
        imageView = findViewById(R.id.imageGallCame);
        btnClose = findViewById(R.id.imageBtnClose);
        btnSave = findViewById(R.id.imageBtnSave);



        btnSave.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String title=editTitle.getText().toString();
                String main=editMain.getText().toString();
                try {
                    DiaryDao.getInstance().writeDiary(title, bitmap, bimapName,main);
                }catch (Exception exc){
                    Log.i("aaaa",exc.getMessage());
                }

                Toast.makeText(Recorde.this, "diary saved", Toast.LENGTH_SHORT).show();
                finish();
            }
        });





        //버튼 클릭시 Activity 닫기
        btnClose.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        //TODO : btnSave 버튼을 누르면 내용이 저장 되도록 기능 설정


        //카메라, 갤러리에서 이미지 사진 찍고 가져오기
        imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showPictureDialog();
            }
        });



    }


    @Override
    protected void onStart() {
        super.onStart();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat smf = new SimpleDateFormat("yyyy.MM.dd.E  HH:m:ss");
        String data = smf.format(calendar.getTime());
        textDate.setText(data);
    }

    private void showPictureDialog(){
        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(this);
        pictureDialog.setTitle("어디서 사진 데려올래?");

        String[] pictureDialogItems = {
                "갤러리에서 이미지 데려오기",
                "카메라로 찍어 이미지 입양하기" };
        pictureDialog.setItems(pictureDialogItems,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                choosePhotoFromGallary();
                                break;
                            case 1:
                                takePhotoFromCamera();
                                break;
                        }
                    }
                });
        pictureDialog.show();
    }

    public void choosePhotoFromGallary() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(galleryIntent, PICK_IMAGE_GALLERY);
    }

    private void takePhotoFromCamera() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, PICK_IMAGE_CAMERA);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == this.RESULT_CANCELED) {
            return;
        }
        if (requestCode == 2) {
            if (data != null) {
                Uri contentURI = data.getData();
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), contentURI);
                    Toast.makeText(Recorde.this, "Image Saved!", Toast.LENGTH_SHORT).show();
                    imageView.setImageBitmap(bitmap);

                    bimapName = DiaryDao.getInstance().getImageNameToUri(data.getData(),Recorde.this);
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(Recorde.this, "Failed!", Toast.LENGTH_SHORT).show();
                }
            }

        } else if (requestCode == 1) {
            if (data != null) {
                bitmap = (Bitmap) data.getExtras().get("data");
                if (bitmap == null) {
                    Toast.makeText(this, "No camera result", Toast.LENGTH_SHORT).show();
                }

                imageView.setImageBitmap(bitmap);

                try {
                    bimapName = DiaryDao.getInstance().saveCameraImg(bitmap, Recorde.this);
                } catch (Exception exc) {
                    Log.i("aaaa", exc.getMessage());
                    return;
                }
                Log.i("aaaa", bimapName);
                Toast.makeText(Recorde.this, "Image Saved!", Toast.LENGTH_SHORT).show();
            }
        }
    }



}
