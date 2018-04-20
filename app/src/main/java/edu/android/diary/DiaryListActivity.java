package edu.android.diary;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class DiaryListActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private List<Diary> dataset;
    private DiaryAdaptor adaptor;
    private static final String TAG = "tttttt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_list);

        dataset = DiaryDao.getInstance().getContactList();
        Log.i(TAG,""+dataset.size());

        recycler = findViewById(R.id.recycle);

        recycler.setHasFixedSize(true);

        recycler.setLayoutManager(new LinearLayoutManager(this));

        adaptor = new DiaryAdaptor();

        recycler.setAdapter(adaptor);
    }

    private void gangshin(){
        recycler.setAdapter(adaptor);
    }

    private class DiaryAdaptor extends RecyclerView.Adapter<DiaryAdaptor.Diaryholder> {

        @NonNull
        @Override
        public Diaryholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(DiaryListActivity.this);
            View view = inflater.inflate(R.layout.diary_list_item, parent, false);

            Diaryholder holder = new Diaryholder(view);

            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull Diaryholder holder, final int position) {
            final Diary diary = dataset.get(position);

            Bitmap bitmap=DiaryDao.getInstance().LoadImage(diary.getPhotoPath());
            holder.imageView.setImageBitmap(bitmap);
            holder.textView.setText(diary.getTxt());

            holder.itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = DirayDetailActivity.newIntent(DiaryListActivity.this, position);
                    startActivity(intent);
                }

            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                            DiaryListActivity.this);

                    // 제목셋팅
                    alertDialogBuilder.setTitle("데이터 삭제");

                    // AlertDialog 셋팅
                    alertDialogBuilder
                            .setMessage("하지 않겠는가?")
                            .setCancelable(false)
                            .setPositiveButton("삭제",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(
                                                DialogInterface dialog, int id) {

                                            DiaryDao.getInstance().deleteDiary(position);

                                            Toast.makeText(DiaryListActivity.this, "삭제됨", Toast.LENGTH_SHORT).show();
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
                this.imageView = itemView.findViewById(R.id.imageView);
                this.textView = itemView.findViewById(R.id.textView);
            }
        }
    }
}
