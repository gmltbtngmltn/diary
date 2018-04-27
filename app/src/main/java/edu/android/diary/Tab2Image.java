package edu.android.diary;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class Tab2Image extends Fragment {

    final int REQ_CODE_SELECT_IMAGE = 100;
    public static final String KEY_IMG= "key_IMG";
    public static final String KEY_MSG = "key_meg";
    public static final String KEY_IMGNAME = "key_NAME";

    private Bitmap bitmap;
    private String bimapName;

    ImageView imageTab2;

    EditText editTab2;
    Button btnTab2;

    TextView tvLetter;
    Uri uri;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab2_diary_image, container, false);
    }


    @Override
    public void onStart() {
        super.onStart();

        View rootView=getView();

        imageTab2 = rootView.findViewById(R.id.tab2ImageView);

        editTab2 = rootView.findViewById(R.id.editTab2);
        tvLetter = rootView.findViewById(R.id.textLetter);

        btnTab2 = rootView.findViewById(R.id.tab2Btn);
        btnTab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), SamplePage.class);

                String msg = editTab2.getText().toString();
                intent.putExtra(KEY_MSG, msg); // 입력한 메시지
                intent.putExtra(KEY_IMGNAME, bimapName);//이미지 이름
                intent.putExtra(KEY_IMG, uri); // 이미지 uri
                try {
                    startActivity(intent);
                }catch (Exception exc){

                }
            }
        });

        editTab2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                tvLetter.setText(s.length() + " /100");

            }
        });
        imageTab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE);
                intent.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, REQ_CODE_SELECT_IMAGE);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {


//        Toast.makeText(getBaseContext(), "resultCode : " + resultCode, Toast.LENGTH_SHORT).show();

        if (requestCode == REQ_CODE_SELECT_IMAGE) {
            if (resultCode == AppCompatActivity.RESULT_OK) {

                try {

                    uri=data.getData();
                    //이미지 데이터를 비트맵으로 받아온다.
                    bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), uri);
                    imageTab2.findViewById(R.id.tab2ImageView);

                    //배치해놓은 ImageView에 set
                    imageTab2.setImageBitmap(bitmap);

                    //Uri에서 이미지 이름을 얻어온다.
                    bimapName = getImageNameToUri(data.getData());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


    }

    private String getImageNameToUri(Uri data) {
            String[] proj = { MediaStore.Images.Media.DATA };
            Cursor cursor = getActivity().managedQuery(data, proj, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA); cursor.moveToFirst();
            String imgPath = cursor.getString(column_index);
            String imgName = imgPath.substring(imgPath.lastIndexOf("/")+1);
            return imgName;
    }


}
