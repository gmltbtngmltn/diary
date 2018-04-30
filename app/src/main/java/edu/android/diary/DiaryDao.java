package edu.android.diary;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
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
import java.util.GregorianCalendar;
import java.util.List;

//각 diary 객체를 생성,삭제,수정,열람

public class DiaryDao {
    private static final String TAG = "tttttt";
    public static final String DIARY_DIRECTORY = "/MyDiary";

    private static final String parentPath= Environment.getExternalStorageDirectory().getPath();
    private static final String childPath=parentPath+DIARY_DIRECTORY;

    private List<Diary> diaries=new ArrayList<>();
    private static DiaryDao instance=null;

    private File filedir=new File(childPath);
    private File file=new File(childPath,"diary.dat");


    //test를 위한 임시 날짜(프로젝트가 완성되면 지워질 부분)
//    private int[] im_shi_date={1919,3,1};
    //test를 위한 임시 날짜


    public void  createDir(){
        filedir=new File(childPath);
        if(!filedir.exists()){
            filedir.mkdirs();
            Log.i(TAG,"폴더가 생성");
        }else{
            Log.i(TAG,"이미 폴더가 있음");
            diaries = getContactList();
        }
    }

    public static DiaryDao getInstance(){
        if(instance==null){
            instance=new DiaryDao();
        }
        return instance;
    }

    private DiaryDao(){}

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
        Log.i("aaaa",imagename);
        File fileB=new File(childPath,imagename);

        InputStream InB = null;
        BufferedInputStream binB = null;
        Bitmap bitmap=null;
        try {
            InB = new FileInputStream(fileB);
            binB = new BufferedInputStream(InB);

            bitmap= BitmapFactory.decodeStream(binB);
        } catch (Exception e) {
            Log.e(TAG,e.getMessage());
        } finally {
            try {
                binB.close();
            } catch (IOException e) {
                Log.e(TAG,e.getMessage());
            }
        }
        return bitmap;
    }//diary객체들을 읽는부분(2) (비트맵 이미지를 파일경로에서 읽어온다)

    public List<Diary> getContactList(int day){
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
    }//diary객체들을 읽는부분(3)(특정 날짜의 diary객체를 읽어온다)

    public String getImageNameToUri(Uri data, Context context) {
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = context.getContentResolver().query(data, proj, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String imgPath = cursor.getString(column_index);
        String imgName = imgPath.substring(imgPath.lastIndexOf("/") + 1);
        return imgName;
    }

    public void writeDiary(String title,Bitmap bitmap, String imagename, String diaryTxt) {

        File fileB = new File(childPath, imagename);

        //test를 위한 임시 날짜(프로젝트가 완성되면 지워질 부분)
//            File file_im_shi_nal_zza = new File(childPath,"im_shi_date.dat");
        //test를 위한 임시 날짜

        Log.i(TAG, "fileB path: " + fileB.getPath());

        Calendar cal = new GregorianCalendar();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour=cal.get(Calendar.HOUR_OF_DAY);
        int minute=cal.get(Calendar.MINUTE);
        int second=cal.get(Calendar.SECOND);

        Diary diary = new Diary(title,imagename, diaryTxt, year, month, day,hour,minute,second);
        diaries.add(diary);

        OutputStream out = null;
        BufferedOutputStream bout = null;
        ObjectOutputStream oos = null;

        OutputStream outB = null;
        BufferedOutputStream boutB = null;

        OutputStream outim = null;
        BufferedOutputStream boutim = null;
        ObjectOutputStream oosim = null;

        try {
            out = new FileOutputStream(file, false);
            bout = new BufferedOutputStream(out);
            oos = new ObjectOutputStream(bout);

            oos.writeObject(diaries);


            outB = new FileOutputStream(fileB, false);
            boutB = new BufferedOutputStream(outB);

            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, boutB);


            //test를 위한 임시 날짜(프로젝트가 완성되면 지워질 부분)
//                im_shi_date[2]++;
//
//                outim = new FileOutputStream(file_im_shi_nal_zza, false);
//                boutim = new BufferedOutputStream(outim);
//                oosim=new ObjectOutputStream(boutim);
//
//                oos.writeObject(im_shi_date);
            //test를 위한 임시 날짜


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
                boutB.close();
//                    boutim.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }//diary객체들을 쓰는부분(1)

    public String saveCameraImg(Bitmap myBitmap, Context context){

        OutputStream outf = null;
        BufferedOutputStream boutf = null;

        try {
            File f = new File(filedir, Calendar.getInstance()
                    .getTimeInMillis() + ".jpg");
            f.createNewFile();
            outf = new FileOutputStream(f, false);
            boutf = new BufferedOutputStream(outf);

            myBitmap.compress(Bitmap.CompressFormat.JPEG, 100, boutf);

            MediaScannerConnection.scanFile(context,
                    new String[]{f.getPath()},
                    new String[]{"image/jpeg"}, null);

            context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE), f.getAbsolutePath());

            boutf.close();

            return f.getName();
        } catch (Exception e1) {
            Log.i("aaaa",e1.getMessage());
        }
        return "";
    }//diary객체들을 쓰는부분(2) (카메라에서 찍은 이미지를 경로에 저장)

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
