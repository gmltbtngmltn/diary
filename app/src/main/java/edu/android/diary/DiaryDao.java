package edu.android.diary;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

//각 diary 객체를 생성,삭제,수정,열람

public class DiaryDao {
    private static final String TAG = "tttttt";

    private static final String parentPath= Environment.getExternalStorageDirectory().getPath();
    private static final String childPath=parentPath+"/custDir";

    private List<Diary> diaries=new ArrayList<>();
    private static DiaryDao instance=null;

    File file=new File(childPath,"diary.dat");

    public static DiaryDao getInstance(){
        if(instance==null){
            instance=new DiaryDao();
        }
        return instance;
    }

    private DiaryDao(){
        File filedir=new File(childPath);
        if(!filedir.exists()){
            filedir.mkdirs();
        }else{
            Log.i(TAG,"이미 폴더가 있음");
            diaries = getContactList();
        }
    }

    public List<Diary> getContactList() {
        InputStream in = null;
        BufferedInputStream bin = null;
        ObjectInputStream ois = null;
        try {
            in = new FileInputStream(file);
            bin = new BufferedInputStream(in);
            ois = new ObjectInputStream(bin);

            diaries = (ArrayList<Diary>) ois.readObject();

        } catch (Exception e) {
            Log.e(TAG,e.getMessage());
        } finally {
            try {
                ois.close();
            } catch (Exception e) {
                Log.e(TAG,e.getMessage());
            }
        }
        return diaries;
    }//diary객체들을 읽는부분(1)

    public Bitmap LoadImage(String imagename){
        File fileB=new File(childPath,imagename);

        InputStream InB = null;
        BufferedInputStream binB = null;
        try {
            InB = new FileInputStream(fileB);
            binB = new BufferedInputStream(InB);

            return BitmapFactory.decodeStream(binB);
        } catch (Exception e) {
            Log.e(TAG,e.getMessage());
        } finally {
            try {
                binB.close();
            } catch (IOException e) {
                Log.e(TAG,e.getMessage());
            }
        }
        return null;
    }//diary객체들을 읽는부분(2) (비트맵 이미지를 파일경로에서 읽어온다)


    public void writeDiary(int type,Bitmap bitmap, String imagename,String diaryTxt) {
        if(type==0) {//이미지 텍스트
            File fileB = new File(childPath, imagename);

            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH) + 1;
            int day = cal.get(Calendar.DAY_OF_MONTH);

            Diary diary = new Diary(imagename, diaryTxt, year, month, day);
            diaries.add(diary);

            OutputStream out = null;
            BufferedOutputStream bout = null;
            ObjectOutputStream oos = null;

            OutputStream outB = null;
            BufferedOutputStream boutB = null;

            try {
                out = new FileOutputStream(file, false);
                bout = new BufferedOutputStream(out);
                oos = new ObjectOutputStream(bout);

                oos.writeObject(diaries);

                outB = new FileOutputStream(fileB, false);
                boutB = new BufferedOutputStream(outB);

                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, boutB);
            } catch (Exception e) {
                Log.e(TAG, e.getMessage());
            } finally {
                try {
                    oos.close();
                    boutB.close();
                } catch (IOException e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        }else if(type==1){// 텍스트only
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH) + 1;
            int day = cal.get(Calendar.DAY_OF_MONTH);

            Diary diary = new Diary(diaryTxt, year, month, day);
            diaries.add(diary);

            OutputStream out = null;
            BufferedOutputStream bout = null;
            ObjectOutputStream oos = null;

            OutputStream outB = null;
            BufferedOutputStream boutB = null;

            try {
                out = new FileOutputStream(file, false);
                bout = new BufferedOutputStream(out);
                oos = new ObjectOutputStream(bout);

                oos.writeObject(diaries);

            } catch (Exception e) {
                Log.e(TAG, e.getMessage());
            } finally {
                try {
                    oos.close();
                    boutB.close();
                } catch (IOException e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        }
    }//diary객체들을 쓰는부분

    public void deleteDiary(int position){
        //배열에서 삭제
        diaries.remove(position);

        //변경된 배열을 파일에 다시 저장
        OutputStream out = null;
        BufferedOutputStream bout = null;
        ObjectOutputStream oos = null;
        try {
            out = new FileOutputStream(file,false);
            bout = new BufferedOutputStream(out);
            oos = new ObjectOutputStream(bout);

            oos.writeObject(diaries);
        } catch (Exception e) {
            Log.e(TAG,e.getMessage());
        } finally {
            try {
                oos.close();
            }catch (IOException e) {
                Log.e(TAG,e.getMessage());
            }
        }

    }//diary객체들을 삭제하는 부분

    public void updateDiary(int position,String imagename, String diaryTxt){
        diaries.get(position).setPhotoPath(imagename);
        diaries.get(position).setTxt(diaryTxt);

        diaries.set(position,diaries.get(position));

        //변경된 배열을 파일에 다시 저장
        OutputStream out = null;
        BufferedOutputStream bout = null;
        ObjectOutputStream oos = null;
        try {
            out = new FileOutputStream(file,false);
            bout = new BufferedOutputStream(out);
            oos = new ObjectOutputStream(bout);

            oos.writeObject(diaries);
        } catch (Exception e) {
            Log.e(TAG,e.getMessage());
        } finally {
            try {
                oos.close();
            }catch (IOException e) {
                Log.e(TAG,e.getMessage());
            }
        }
    }//diary객체들을 수정하는 부분

}
