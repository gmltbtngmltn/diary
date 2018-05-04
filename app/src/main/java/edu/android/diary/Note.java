package edu.android.diary;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;

public class Note extends AppCompatActivity {

    public static final String TAG = "Note";

    private DiaryDao dao;

    private Button add, returnto, delete;
    private ListView listView;

    private SingerAdapter adapterd;
    private SingerAdapter adapter;
    public List<NoteSI> notedata;

    Calendar cal;
    DatePickerDialog datePickerDialog;

    private int year;
    private int month;
    private int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        notedata=DiaryDao.getInstance().getNoteSISList();//파일경로에 쓰여진 note객체들을 읽어온다
        //Toast.makeText(Note.this, "노트 = "+notedata.size(), Toast.LENGTH_SHORT).show();

        add = findViewById(R.id.add);
        returnto = findViewById(R.id.returnto);

        listView = findViewById(R.id.listView);

        adapter = new SingerAdapter(this, notedata);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                detailed();
//                Intent intent = NoteDatailed.newIntent(Note.this,position);
//                startActivity(intent);
            }
        });
    }

    private void detailed() {
        NoteDatailed noteDatailed = new NoteDatailed();
        noteDatailed.show(getSupportFragmentManager(), "noteDatailed");
        notedata=DiaryDao.getInstance().getNoteSISList();
    }


    public void returnto(View view) {
        Intent intent = new Intent(Note.this, DaySearch.class);
        startActivity(intent);
    }


    public void delete(View view) {
        notedata=DiaryDao.getInstance().getNoteSISList();

       // DiaryDao.getInstance().deleteNote(); //파일경로에 note객체를 쓴다
        Toast.makeText(Note.this, "삭제됨 = "+notedata.size(), Toast.LENGTH_SHORT).show();

    }

    public void add(View view) {
//        NoteNewSeve noteNewSeve = new NoteNewSeve();
//        noteNewSeve.show(getSupportFragmentManager(), "noteNewSave");



        AlertDialog.Builder mBuilder = new AlertDialog.Builder(Note.this);
        View mView = getLayoutInflater().inflate(R.layout.activity_note_new_save, null);
        final EditText contentInput = (EditText) mView.findViewById(R.id.contentInput);
        final TextView finalDayInput = (TextView) mView.findViewById(R.id.finalDayInput);
        final Button btnsave = (Button) mView.findViewById(R.id.btnsave);
        final Button btnCalendar = mView.findViewById(R.id.btnCalendar);
        //final Button btnClose = mView.findViewById(R.id.btnClose);

        btnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cal = Calendar.getInstance();
                year = cal.get(Calendar.YEAR);
                month = cal.get(Calendar.MONTH);
                day = cal.get(Calendar.DAY_OF_MONTH);
                Log.i(TAG, "year: " + year + " month: " + month + " day: " + day);

                datePickerDialog = new DatePickerDialog(Note.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int fyear, int fmonth, int fdayOfMonth) {
                                finalDayInput.setText(fyear + "/" + (fmonth +1) + "/" + fdayOfMonth);
                                year=fyear;
                                month=fmonth;
                                day=fdayOfMonth;
                            }
                        }, year, month, day);
                datePickerDialog.show();
            }
        });
        Log.i(TAG, "year: " + year + " month: " + month + " day: " + day);

        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String naeyong  = contentInput.getText().toString();

                if (!contentInput.getText().toString().isEmpty() && !finalDayInput.getText().toString().equals("")) { // 고칠점: 할일만 적어도 넘어감
                    DiaryDao.getInstance().writeNote(naeyong,year,month,day); //파일경로에 note객체를 쓴다
//                    Toast.makeText(Note.this, "저장됨 = "+notedata.size(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(Note.this, "저장 했으면 backButton을 눌러 주세요", Toast.LENGTH_SHORT).show();

//                    Toast.makeText(Note.this, "할 일과 마감일이 써있음", Toast.LENGTH_SHORT).show();
//                    memoMessage.setText(mContentInput.getText());
//                    memoFinalDay.setText(mfinalDayInput.getText());
//                    dialog.dismiss();
                }else {
                    Toast.makeText(Note.this, "할 일과 마감일이 쓰여 있지 않음", Toast.LENGTH_SHORT).show();
                }
            }
        });

//        btnClose.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });

        dialog.show();
    }

    class SingerAdapter extends ArrayAdapter<NoteSI> {
        private Context context;
        private List<NoteSI> notedata;

        public SingerAdapter(@NonNull Context context, @NonNull List<NoteSI> objects) {
            super(context, -1, objects);
            this.context = context;
            this.notedata =objects;
        }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(context);
            // 리스트뷰에 그려질 아이템 하나의 View를 생성
            View view = inflater.inflate(R.layout.activity_note_slist, parent, false);

            // 아이템 뷰에 있는 이미지뷰의 내용을 작성

            TextView contentSee = view.findViewById(R.id.contentSee);
            contentSee.setText(notedata.get(position).getContent());

            TextView finalDaySee = view.findViewById(R.id.finalDaySee);
            finalDaySee.setText(notedata.get(position).getYear()+"/"+ (notedata.get(position).getMonth() +1) +"/"+notedata.get(position).getDay());

            AlertDialog.Builder mBuilder = new AlertDialog.Builder(Note.this);

//            Button del = findViewById(R.id.delete);
//            del.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(Note.this,"del",Toast.LENGTH_SHORT).show();
//                }
//            });

            return view;
        }
    }


}
