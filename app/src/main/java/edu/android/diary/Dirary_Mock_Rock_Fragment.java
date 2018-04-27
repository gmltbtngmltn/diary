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

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Dirary_Mock_Rock_Fragment extends Fragment {

    private RecyclerView recycler;
    private List<Diary> dataset;
    private DiaryAdaptor adaptor;

    private int year,month,day;

    public Dirary_Mock_Rock_Fragment() {

    }

    public static Dirary_Mock_Rock_Fragment newInstance(int year,int month,int day){
        Dirary_Mock_Rock_Fragment fragment=new Dirary_Mock_Rock_Fragment();
        fragment.year=year;
        fragment.day=month;
        fragment.day=day;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dirary__mock__rock_, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view=getView();
        dataset = DiaryDao.getInstance().getContactList();

        recycler = view.findViewById(R.id.recycler);

        recycler.setHasFixedSize(true);

        recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        adaptor = new DiaryAdaptor();

        recycler.setAdapter(adaptor);
    }

    private void gangshin(){
        recycler.setAdapter(adaptor);
    }

    private class DiaryAdaptor extends RecyclerView.Adapter<DiaryAdaptor.Diaryholder> {

        @NonNull
        @Override
        public DiaryAdaptor.Diaryholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View view = inflater.inflate(R.layout.diary_list_item0, parent, false);

            DiaryAdaptor.Diaryholder holder = new DiaryAdaptor.Diaryholder(view);

            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull DiaryAdaptor.Diaryholder holder, final int position) {
            Diary diary = dataset.get(position);
            Bitmap bitmap = DiaryDao.getInstance().LoadImage(diary.getPhotoPath());

            holder.imageView.setImageBitmap(bitmap);
            holder.textView.setText(diary.getYear() + "/" + diary.getMonth() + "/" + diary.getDay());

            holder.itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = DirayDetailActivity.newIntent(getContext(), position);
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

                                    DiaryDao.getInstance().deleteDiary(position);

                                    Toast.makeText(getContext(), "삭제됨", Toast.LENGTH_SHORT).show();
                                    dataset = DiaryDao.getInstance().getContactList();
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
            private TextView textView;

            public Diaryholder(View itemView) {
                super(itemView);
                this.itemView = itemView;
                this.imageView = itemView.findViewById(R.id.imageView0);
                this.textView = itemView.findViewById(R.id.textView0);
            }
        }
    }
}
