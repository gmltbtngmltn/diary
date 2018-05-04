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

    private List<Integer> realindex=new ArrayList<>();

    private List<Diary> diaries=new ArrayList<>();
    private List<NoteSI> noteSIS=new ArrayList<>();

    private static DiaryDao instance=null;

    private File filedir = new File(childPath);

    File themnumf = new File(childPath,"themenum.dat");

    private int themeNum;

    private File file = new File(childPath,"diary.dat");//diart객체파일
    private File filenote = new File(childPath,"Note.dat");//note객체파일


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
            noteSIS = getNoteSISList();
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


    public List<Diary> getContactList(int year,int month,int day){
        InputStream in = null;
        BufferedInputStream bin = null;
        ObjectInputStream ois = null;
        List<Diary> diariesBydate=new ArrayList<>();
        List<Integer> integers=new ArrayList<>();

        try {
            in = new FileInputStream(file);
            bin = new BufferedInputStream(in);
            ois = new ObjectInputStream(bin);

            diaries = (ArrayList<Diary>) ois.readObject();
            for(int i=0;i<diaries.size();i++){
                if(diaries.get(i).getYear()==year && diaries.get(i).getMonth()==month && diaries.get(i).getDay()==day){
                    diariesBydate.add(diaries.get(i));
                    integers.add(i);
                }
            }
            realindex=integers;

        } catch (Exception e) {
            Log.e(TAG,e.getMessage());
        } finally {
            try {
                ois.close();
            } catch (Exception e) {
                Log.e(TAG,e.getMessage());
            }
        }
        return diariesBydate;
    }//diary객체들을 읽는부분(4)(특정 날짜의 diary객체를 읽어온다 (년, 월, 일))


    // 검색기능에 사용
    public List<Diary> getContactList(String text_Or_title){
        InputStream in = null;
        BufferedInputStream bin = null;
        ObjectInputStream ois = null;
        List<Diary> diariesBydate=null;

        try {
            in = new FileInputStream(file);
            bin = new BufferedInputStream(in);
            ois = new ObjectInputStream(bin);

            diaries = (ArrayList<Diary>) ois.readObject();
            diariesBydate=new ArrayList<>();

            for(int i=0;i<diaries.size();i++){
                if(diaries.get(i).getTxt()==text_Or_title){
                    diariesBydate.add(diaries.get(i));
                }
            }
        } catch (Exception e) {
            Log.e(TAG,e.getMessage());
        } finally {
            try {
                ois.close();
            } catch (Exception e) {
                Log.e(TAG,e.getMessage());
            }
        }
        return diariesBydate;
    }//diary객체들을 읽는부분(4)(특정 내용 혹은 제목의 diary객체를 읽어온다 (년, 월, 일))

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

//        OutputStream outim = null;
//        BufferedOutputStream boutim = null;
//        ObjectOutputStream oosim = null;

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
//        String imagename=diaries.get(position).getPhotoPath();
//        File fileB = new File(childPath, imagename);
//        fileB.delete();

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

    public void deleteDiary(List<Diary> list,int position){

        //배열에서 삭제
//        String imagename=list.get(position).getPhotoPath();
//        File fileB = new File(childPath, imagename);
//        fileB.delete();
        
        list.remove(position);
        diaries.remove(realindex.get(0)+position);

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

    }//diary객체들을 삭제하는 부분(오버로딩)

    public void updateDiary(int position,Bitmap bitmap,String imagename, String diaryTxt){

        File fileB = new File(childPath, imagename);

        diaries.get(position).setPhotoPath(imagename);
        diaries.get(position).setTxt(diaryTxt);

        diaries.set(position,diaries.get(position));

        //변경된 배열을 파일에 다시 저장
        OutputStream out = null;
        BufferedOutputStream bout = null;
        ObjectOutputStream oos = null;

        OutputStream outB = null;
        BufferedOutputStream boutB = null;

        try {
            out = new FileOutputStream(file,false);
            bout = new BufferedOutputStream(out);
            oos = new ObjectOutputStream(bout);

            oos.writeObject(diaries);


            outB = new FileOutputStream(fileB, false);
            boutB = new BufferedOutputStream(outB);

            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, boutB);
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

    public void updateDiary(List<Diary> list, int position,Bitmap bitmap,String imagename, String diaryTxt){

        File fileB = new File(childPath, imagename);

        list.get(position).setPhotoPath(imagename);
        list.get(position).setTxt(diaryTxt);

        diaries.set(realindex.get(0)+position,list.get(position));

        //변경된 배열을 파일에 다시 저장
        OutputStream out = null;
        BufferedOutputStream bout = null;
        ObjectOutputStream oos = null;

        OutputStream outB = null;
        BufferedOutputStream boutB = null;

        try {
            out = new FileOutputStream(file,false);
            bout = new BufferedOutputStream(out);
            oos = new ObjectOutputStream(bout);

            oos.writeObject(diaries);


            outB = new FileOutputStream(fileB, false);
            boutB = new BufferedOutputStream(outB);

            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, boutB);
        } catch (Exception e) {
            Log.e(TAG,e.getMessage());
        } finally {
            try {
                oos.close();
            }catch (IOException e) {
                Log.e(TAG,e.getMessage());
            }
        }
    }//diary객체들을 수정하는 부분(오버로딩)

    public void saveThemeNum(int num){
        themeNum=num;

        OutputStream outn = null;
        BufferedOutputStream boutn = null;
        ObjectOutputStream oosn = null;

        try {
            outn = new FileOutputStream(themnumf, false);
            boutn = new BufferedOutputStream(outn);
            oosn=new ObjectOutputStream(boutn);

            oosn.writeObject(themeNum);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                oosn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    public int getThemeNum(){

        InputStream inn = null;
        BufferedInputStream binn = null;
        ObjectInputStream oisn = null;

        try {
            inn = new FileInputStream(themnumf);
            binn = new BufferedInputStream(inn);
            oisn=new ObjectInputStream(binn);

            themeNum= (int) oisn.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                oisn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return themeNum;
    }




    public List<NoteSI> getNoteSISList() {
        InputStream in = null;
        BufferedInputStream bin = null;
        ObjectInputStream ois = null;
        try {
            in = new FileInputStream(filenote);
            bin = new BufferedInputStream(in);
            ois = new ObjectInputStream(bin);

            noteSIS = (ArrayList<NoteSI>) ois.readObject();

        } catch (Exception e) {
            Log.e(TAG,e.getMessage());
        } finally {
            try {
                ois.close();
            } catch (Exception e) {
                Log.e(TAG,e.getMessage());
            }
        }
        return noteSIS;
    }//note객체들을 읽는부분(1)


    public void writeNote(String content,int year, int month, int day) {


        NoteSI noteSI = new NoteSI(content,year, month, day);
        noteSIS.add(noteSI);

        OutputStream out = null;
        BufferedOutputStream bout = null;
        ObjectOutputStream oos = null;


        try {
            out = new FileOutputStream(filenote, false);
            bout = new BufferedOutputStream(out);
            oos = new ObjectOutputStream(bout);

            oos.writeObject(noteSIS);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//note객체들을 쓰는부분(1)

    public void deleteNote(int position){
        //배열에서 삭제
        noteSIS.remove(position);

        //변경된 배열을 파일에 다시 저장
        OutputStream out = null;
        BufferedOutputStream bout = null;
        ObjectOutputStream oos = null;
        try {
            out = new FileOutputStream(filenote,false);
            bout = new BufferedOutputStream(out);
            oos = new ObjectOutputStream(bout);

            oos.writeObject(noteSIS);
        } catch (Exception e) {
            Log.e(TAG,e.getMessage());
        } finally {
            try {
                oos.close();
            }catch (IOException e) {
                Log.e(TAG,e.getMessage());
            }
        }

    }//note객체들을 삭제하는 부분

    public void updateNote(int position,String content,int year, int month, int day){
        noteSIS.get(position).setContent(content);
        noteSIS.get(position).setYear(year);
        noteSIS.get(position).setMonth(month);
        noteSIS.get(position).setDay(day);

        //변경된 배열을 파일에 다시 저장
        OutputStream out = null;
        BufferedOutputStream bout = null;
        ObjectOutputStream oos = null;
        try {
            out = new FileOutputStream(filenote,false);
            bout = new BufferedOutputStream(out);
            oos = new ObjectOutputStream(bout);

            oos.writeObject(noteSIS);
        } catch (Exception e) {
            Log.e(TAG,e.getMessage());
        } finally {
            try {
                oos.close();
            }catch (IOException e) {
                Log.e(TAG,e.getMessage());
            }
        }
    }//note객체들을 수정하는 부분
}
