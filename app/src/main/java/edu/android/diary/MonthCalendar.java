package edu.android.diary;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Calendar;

public class MonthCalendar extends Activity {
    //Calendar mCal = Calendar.getInstance();

    GridView mGridView;
    DataAdapter adapter;
    ArrayList arrData;
    Calendar mCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month_calendar);

        // Calendar 객체 생성
        mCal = Calendar.getInstance();

        // 달력 세팅
        setCalendarData(mCal.get(Calendar.MONTH)+1);
    }

    public void setCalendarData(int month) {
        arrData = new ArrayList();
        // 요일은 +1해야 되기때문에 달력에 요일을 세팅할때에는 -1 해준다
        mCal.set(Calendar.MONTH, month-1);

        for (int i = 0; i < mCal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            arrData.add(i + 1);
        }

        adapter
    }

}

// GridView와 연결해주기위한 어댑터 구성
class DataAdapter extends BaseAdapter {
    private Context context;
    private

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
