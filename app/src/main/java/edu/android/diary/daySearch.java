package edu.android.diary;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class daySearch extends AppCompatActivity {

    Button bfecha,bot_ki;
    EditText efecha;
    private int dia, mes, ano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daysearch);

        bfecha = (Button)findViewById(R.id.bfeca);
        efecha = (EditText)findViewById(R.id.efecha);

        bfecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v == bfecha) {

                    final Calendar c = Calendar.getInstance();
                    dia = c.get(Calendar.DAY_OF_MONTH);
                    mes = c.get(Calendar.MONTH);
                    ano = c.get(Calendar.YEAR);

                    DatePickerDialog datePickerDialog = new DatePickerDialog(daySearch.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            efecha.setText(year + "/" + (month + 1) + "/" + dayOfMonth);
                        }

                    }
                            ,dia, mes, ano);
                    datePickerDialog.show();

                }//end if

            }//end onClick()
        });
//
//        tranj(0);//기본적으로 전체기간의 일기가보여짐

        bot_ki = (Button)findViewById(R.id.btn_gi_rock_botki);
        bot_ki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tranj(1);//검색된 날짜의 일기가보여짐
            }
        });

    }//end onCreate


    public void tranj(int command){
        FragmentManager fm=getSupportFragmentManager();
        Fragment fragment=fm.findFragmentById(R.id.mock_rock_frag);
        if(fragment==null){
            FragmentTransaction transaction=fm.beginTransaction();
            Dirary_Mock_Rock_Fragment diraryMockRockFragment=Dirary_Mock_Rock_Fragment.newInstance(command,dia, mes, ano);
            transaction.replace(R.id.mock_rock_frag,diraryMockRockFragment);
            transaction.commit();
        }
    }
}
