package edu.android.diary;

/*
    <로 옆에서 달력이 나오고 최근 일기 쓴 목록이 나오는 페이지
 */

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MonthListView extends AppCompatActivity
            implements NavigationView.OnNavigationItemSelectedListener{

    private List<MonthListModel> View;
    private ListView MonthView;

    public class MonthAdapter extends ArrayList<MonthListModel> {
      private
    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month_list_view);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab); // 떠있는 버튼
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    public void onBackPressed() {// 뒤로 가기 버튼을 실행시키는 코드
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {// 만약 드로어가 열려 있으면 드로어를 닫는다
            drawer.closeDrawer(GravityCompat.START);
        }else {// 드로어가 열려 있지 않으면 부모를 종료합니뎅
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
