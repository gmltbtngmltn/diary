package edu.android.diary;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_list);

        dataset = DiaryDao.getInstance().getContactList();

        recycler = findViewById(R.id.recycle);

        recycler.setHasFixedSize(true);

        recycler.setLayoutManager(new LinearLayoutManager(this));

        DiaryAdaptor adaptor = new DiaryAdaptor();

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
        public void onBindViewHolder(@NonNull Diaryholder holder, int position) {
            final Diary diary = dataset.get(position);

            holder.imageView.setImageResource(diary.getPhotoId());
            holder.textView.setText(diary.getTxt());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Intent intent=DetailActivity.newIntent(MainActivity.this,position);
//                    startActivity(intent);
                    Toast.makeText(DiaryListActivity.this, "다음화면으로~", Toast.LENGTH_SHORT).show();
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
