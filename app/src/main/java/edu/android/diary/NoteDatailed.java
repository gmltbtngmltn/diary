package edu.android.diary;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class NoteDatailed extends AppCompatDialogFragment {

    private TextView contentSees, finalDaySeess;

    private static final String EXTRA_CONTACT_INDEX = "contact_index";
    private int index;

    public static Intent newIntent(Context context, int index) {
        Intent intent = new Intent(context, NoteDatailed.class);
        intent.putExtra(EXTRA_CONTACT_INDEX, index);
        return intent;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_note_detailed, null);

        contentSees = view.findViewById(R.id.contentSees);
        finalDaySeess = view.findViewById(R.id.finalDaySees);

        builder.setView(view).setTitle("상세보기")
                .setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DiaryDao.getInstance().deleteNote(index);
                    }
                });

        return builder.create();
    }

    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_note_detailed);
//
//        Intent intent = getIntent();
//
//        index = intent.getIntExtra(EXTRA_CONTACT_INDEX, 0);
//
//        TextView contentSees = findViewById(R.id.contentSees);
//        //contentSees.setText();
//
//        TextView finalDaySeess = findViewById(R.id.finalDaySeess);
//        //finalDaySeess.setText(NoteSI.getPhone());
//
//    }

//    public void deleteNote(View view) {
//        DiaryDao.getInstance().deleteNote(index);
//    }
}
