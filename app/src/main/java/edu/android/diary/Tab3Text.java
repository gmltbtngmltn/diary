//package edu.android.diary;
//
//import android.content.Intent;
//import android.support.v4.app.Fragment;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.EditText;
//
//public class Tab3Text extends Fragment{
//
//    EditText editTitle, editText;
//    Button btnTab3;
//    public static final String KEY_TITLE= "KEY_MSG";
//    public static final String KEY_DIARY= "KEY_MSG2";
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View rootView = inflater.inflate(R.layout.tab3_diary_text, container, false);
//
//        editTitle = rootView.findViewById(R.id.editTab3Title);
//        editText = rootView.findViewById(R.id.editTab3Diary);
//        btnTab3 = rootView.findViewById(R.id.tab3Btn);
//
//        return rootView;
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        btnTab3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), SamplePage2.class);
//
//                String msgt = editTitle.getText().toString();
//                String msgd = editText.getText().toString();
//                intent.putExtra(KEY_TITLE, msgt); // 제목
//                intent.putExtra(KEY_DIARY, msgd); //내용
//
//                startActivity(intent);
//            }
//        });
//
//    }
//}
