package edu.android.diary;


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
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
public class DiaryList_FragmentViewpager extends Fragment {

    private ViewPager pager;
    private List<Diary> dataset;
    private CustomAdapter adapter;

    public DiaryList_FragmentViewpager() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_diary_list__fragment_viewfliper, container, false);
    }


    @Override
    public void onStart() {
        super.onStart();
        View view=getView();

        pager= (ViewPager)view.findViewById(R.id.pager);



        //ViewPager에 설정할 Adapter 객체 생성

        //ListView에서 사용하는 Adapter와 같은 역할.

        //다만. ViewPager로 스크롤 될 수 있도록 되어 있다는 것이 다름

        //PagerAdapter를 상속받은 CustomAdapter 객체 생성

        //CustomAdapter에게 LayoutInflater 객체 전달

        dataset = DiaryDao.getInstance().getContactList();

        adapter= new CustomAdapter(getLayoutInflater());

        //ViewPager에 Adapter 설정

        pager.setAdapter(adapter);

    }

    private void gangshin(){
        pager.setAdapter(adapter);
    }

    class CustomAdapter extends PagerAdapter {

        LayoutInflater inflater;

        public CustomAdapter(LayoutInflater inflater) {
            // TODO Auto-generated constructor stub
            //전달 받은 LayoutInflater를 멤버변수로 전달
            this.inflater=inflater;
        }

        //PagerAdapter가 가지고 잇는 View의 개수를 리턴

        //보통 보여줘야하는 이미지 배열 데이터의 길이를 리턴

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return dataset.size();
        }



        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            // TODO Auto-generated method stub
            View view=null;

            //새로운 View 객체를 Layoutinflater를 이용해서 생성

            //만들어질 View의 설계는 res폴더>>layout폴더>>viewpater_childview.xml 레이아웃 파일 사용

            view= inflater.inflate(R.layout.diary_list_item_veiwpager, null);



            //만들어진 View안에 있는 ImageView 객체 참조

            //위에서 inflated 되어 만들어진 view로부터 findViewById()를 해야 하는 것에 주의.

            ImageView imageView= (ImageView)view.findViewById(R.id.imageView1);
            TextView textTitle=view.findViewById(R.id.texttitle1);
            TextView text=view.findViewById(R.id.text1);

            Diary diary = dataset.get(position);
            Bitmap bitmap = DiaryDao.getInstance().LoadImage(diary.getPhotoPath());
            imageView.setImageBitmap(bitmap);

            String date=diary.getYear() + "/" + diary.getMonth() + "/" + diary.getDay()+"/"+diary.getHour()+"/"+diary.getMinute()+"/"+diary.getSecond();
            textTitle.setText("Title : "+diary.getTitle()+"   ("+date+")");
            text.setText(diary.getTxt());

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = DetailText.newIntent(getContext(), position);
                    startActivity(intent);
                }
            });

            view.setOnLongClickListener(new View.OnLongClickListener() {
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
            //ViewPager에 만들어 낸 View 추가

            container.addView(view);

            return view;

        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // TODO Auto-generated method stub

            //ViewPager에서 보이지 않는 View는 제거

            //세번째 파라미터가 View 객체 이지만 데이터 타입이 Object여서 형변환 실시

            container.removeView((View)object);
        }



        //instantiateItem() 메소드에서 리턴된 Ojbect가 View가  맞는지 확인하는 메소드

        @Override

        public boolean isViewFromObject(View v, Object obj) {
            // TODO Auto-generated method stub
            return v==obj;
        }

    }


}
