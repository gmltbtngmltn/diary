package edu.android.diary;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class daySearch extends AppCompatActivity {

    Button bfecha;
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

    }//end onCreate
}
