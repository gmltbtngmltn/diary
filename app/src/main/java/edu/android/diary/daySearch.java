package edu.android.diary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;

public class daySearch extends AppCompatActivity {

    private DatePicker datePicker;
    private Button check;

    public int curYear;
    public int curMonth;
    public int curDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daysearch);

        Calendar calendar = Calendar.getInstance();
        curYear = calendar.get(Calendar.YEAR);
        curMonth = calendar.get(Calendar.MONTH);
        curDay = calendar.get(Calendar.DAY_OF_MONTH);

        datePicker = findViewById(R.id.datePicker);
        datePicker.init(curYear, curMonth, curDay, new DatePicker.OnDateChangedListener() {
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // 새로 정의한 리스너로 이벤트 전달
                // getHour(), getMinute() 메소드는 API 23부터 지원함
                curYear = year;
                curMonth = monthOfYear + 1;
                curDay = dayOfMonth;
                //Toast.makeText(MainActivity.this, "year:" + year + "month:" + monthOfYear + "day:" + dayOfMonth, Toast.LENGTH_LONG).show();
            }
        });
        check = findViewById(R.id.check);
    }

    public void next(View v) {
        Intent intent = new Intent(daySearch.this, DirayListActivity.class);
        intent.putExtra("SELECTED_YEAR", curYear);
        intent.putExtra("SELECTED_MONTH", curMonth);
        intent.putExtra("SELECTED_DAY", curDay);

        startActivity(intent);
    }
}



//    Button bfecha,bot_ki;
//    EditText efecha;
//    private int dia, mes, ano;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.daysearch);
//
//        bfecha = (Button)findViewById(R.id.bfeca);
//        efecha = (EditText)findViewById(R.id.efecha);
//
//        bfecha.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (v == bfecha) {
//
//                    final Calendar c = Calendar.getInstance();
//                    dia = c.get(Calendar.DAY_OF_MONTH);
//                    mes = c.get(Calendar.MONTH);
//                    ano = c.get(Calendar.YEAR);
//
//                    DatePickerDialog datePickerDialog = new DatePickerDialog(daySearch.this, new DatePickerDialog.OnDateSetListener() {
//                        @Override
//                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                            efecha.setText(year + "/" + (month + 1) + "/" + dayOfMonth);
//                        }
//
//                    }
//                            ,dia, mes, ano);
//                    datePickerDialog.show();
//
//                }//end if
//
//            }//end onClick()
//        });
//       tranj();//기본적으로 전체기간의 일기가보여짐
//
////        bot_ki = (Button)findViewById(R.id.btn_gi_rock_botki);
////        bot_ki.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                tranj();//검색된 날짜의 일기가보여짐
////            }
////        });
//
//    }//end onCreate
//
//
//    public void tranj(){
//        FragmentManager fm=getSupportFragmentManager();
//        Fragment fragment=fm.findFragmentById(R.id.mock_rock_frag);
//        if(fragment==null){
//            FragmentTransaction transaction=fm.beginTransaction();
//            DiaryList_FragmentRecycler diraryMockRockFragment= DiaryList_FragmentRecycler.newInstance(dia, mes, ano);
//            transaction.replace(R.id.mock_rock_frag,diraryMockRockFragment);
//            transaction.commit();
//        }
//    }

