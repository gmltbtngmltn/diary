package edu.android.diary;


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

import static edu.android.diary.DiaryList_FragmentViewpager.KEY_ARR;


/**
 * A simple {@link Fragment} subclass.
 */
public class DiaryList_FragmentRecycler extends Fragment {

    private RecyclerView recycler;
    private List<Diary> dataset;
    private DiaryAdaptor adaptor;

    private int comm;//'전체보기 or 특정 날짜 것 보기'의 여부
    private int year,month,day;

    public DiaryList_FragmentRecycler() {

    }


    public static DiaryList_FragmentRecycler newInstance(int comm,int year, int month, int day){
        DiaryList_FragmentRecycler fragment=new DiaryList_FragmentRecycler();
        fragment.comm=comm;
        fragment.year=year;
        fragment.month=month;
        fragment.day=day;
        Log.i("aaaa","year="+year+"month="+month+"day="+day);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dirary_list_recyler, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view=getView();
        Log.i("aaaa","ffff comm = "+comm);
        if(comm==0) {
            dataset = DiaryDao.getInstance().getContactList();
        }else if(comm==1){
            dataset = DiaryDao.getInstance().getContactList(year,month,day);
            Log.i("aaaa","year="+year+"month="+month+"day="+day);
        }

        Log.i("aaaa","array = "+dataset.size());

        recycler = view.findViewById(R.id.recycler);

        recycler.setHasFixedSize(true);

        recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        adaptor = new DiaryAdaptor();

        recycler.setAdapter(adaptor);

        /**/


    }

    private void gangshin(){
        recycler.setAdapter(adaptor);
    }

    private class DiaryAdaptor extends RecyclerView.Adapter<DiaryAdaptor.Diaryholder> {

        @NonNull
        @Override
        public DiaryAdaptor.Diaryholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View view = inflater.inflate(R.layout.diary_list_item_recrycler, parent, false);

            DiaryAdaptor.Diaryholder holder = new DiaryAdaptor.Diaryholder(view);

            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull DiaryAdaptor.Diaryholder holder, final int position) {
            Diary diary = dataset.get(position);

            try {
                Bitmap bitmap = DiaryDao.getInstance().LoadImage(diary.getPhotoPath());

                holder.imageView.setImageBitmap(bitmap);
            }catch (Exception exc){
                holder.imageView.setImageResource(R.drawable.defaultimg);
            }

            holder.textTitle.setText(diary.getTitle());
            holder.textdate.setText(diary.getYear() + "/" + diary.getMonth() + "/" + diary.getDay()+"/"+diary.getHour()+"/"+diary.getMinute()+"/"+diary.getSecond());

            holder.itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = DetailText.newIntent(getContext(), position,comm);
                    intent.putExtra(KEY_ARR, (Serializable) dataset);
                    startActivity(intent);
                }

            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    getContext());

                    // 제목셋팅
                    alertDialogBuilder.setTitle("데이터 삭제");

                    // AlertDialog 셋팅
                    alertDialogBuilder.setMessage("하지 않겠는가?")
                            .setCancelable(false)
                            .setPositiveButton("삭제",
                            new DialogInterface.OnClickListener() {
                                public void onClick(
                                        DialogInterface dialog, int id) {

                                    if(comm==0) {
                                        DiaryDao.getInstance().deleteDiary(position);
                                        dataset = DiaryDao.getInstance().getContactList();
                                    }else if(comm==1){
                                        DiaryDao.getInstance().deleteDiary(dataset,position);
                                        dataset = DiaryDao.getInstance().getContactList(year,month,day);
                                    }
                                    Toast.makeText(getContext(), "삭제됨", Toast.LENGTH_SHORT).show();

                                    gangshin();
                                }
                            })
                            .setNegativeButton("취소",
                            new DialogInterface.OnClickListener() {
                                public void onClick(
                                        DialogInterface dialog, int id) {
                                    // 다이얼로그를 취소한다
                                    dialog.cancel();
                                }
                            });
                    // 다이얼로그 생성
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    // 다이얼로그 보여주기
                    alertDialog.show();
                    return true;
                }
            });
        }

        @Override
        public int getItemCount() {
            return dataset.size();
        }

        class Diaryholder extends RecyclerView.ViewHolder {
            private View itemView;
            private ImageView imageView;
            private TextView textTitle,textdate;

            public Diaryholder(View itemView) {
                super(itemView);
                this.itemView = itemView;
                this.imageView = itemView.findViewById(R.id.imageView0);
                this.textdate = itemView.findViewById(R.id.textdate);
                this.textTitle=itemView.findViewById(R.id.texttitle);
            }
        }
    }
}
