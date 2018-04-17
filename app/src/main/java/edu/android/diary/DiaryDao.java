package edu.android.diary;

import java.util.ArrayList;
import java.util.List;

//각 diary 객체를 생성,삭제,수정,열람

public class DiaryDao {
    private static final int[] IMAGE_IDS = {
            R.drawable.sample1, R.drawable.sample2, R.drawable.sample3,
            R.drawable.sample4, R.drawable.sample5, R.drawable.sample6,
            R.drawable.sample7, R.drawable.sample8, R.drawable.sample9,
            R.drawable.sample10, R.drawable.sample11, R.drawable.sample12,
            R.drawable.sample13
    };//이부분은 향후에 갤러리에서 사진파일을 받아오는 부분으로 대체될 것임

    private List<Diary> diaries=new ArrayList<>();
    private static DiaryDao instance=null;

    public static DiaryDao getInstance(){
        if(instance==null){
            instance=new DiaryDao();
        }
        return instance;
    }

    private DiaryDao() {
        makedata();
    }

    ////////////
    private void makedata() {
        for (int i = 0; i < 100; i++) {
            Diary contact = new Diary(IMAGE_IDS[i % IMAGE_IDS.length],"shit"+i);
            diaries.add(contact);
        }
    }//임시
    /////////////////

    public List<Diary> getContactList() {
        return diaries;
    }//diary객체들을 전체 열람하는 부분
    //diary의 Array에서 선택된 index의 정보를 볼때 =
    // getInstance().getContactList().get(index).getPhotoId; , getInstance().getContactList().get(index).getTxt;
    
    public void writeDiary(int photoId, String diaryTxt) {
        Diary contact = new Diary(photoId,diaryTxt);
        diaries.add(contact);
    }//diary객체들을 생성하는 부분

    public void deleteDiary(int position){
        diaries.remove(position);
    }//diary객체들을 삭제하는 부분

    public void updateDiary(int position,int photoId, String diaryTxt){
        Diary diary=new Diary(photoId,diaryTxt);
        diaries.set(position,diary);
    }//diary객체들을 수정하는 부분

}
