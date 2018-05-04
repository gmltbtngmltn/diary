package edu.android.diary;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NoteDetailed extends AppCompatActivity {

    private TextView contentSees, finalDaySeess;

    private static final String EXTRA_CONTACT_INDEX = "contact_index";

    public static Intent newIntent(Context context, int index) {
        Intent intent = new Intent(context, NoteDetailed.class);
        intent.putExtra(EXTRA_CONTACT_INDEX, index);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detailed);

        Intent intent = getIntent();

        int index = intent.getIntExtra(EXTRA_CONTACT_INDEX, 0);

//        Note note = DiaryDao.getInstance()/*씽글턴*/.getNoteSISList().get(index);

        TextView contentSees = findViewById(R.id.contentSees);
        //contentSees.setText();

        TextView finalDaySeess = findViewById(R.id.finalDaySeess);
        //finalDaySeess.setText(NoteSI.getPhone());

    }

}
