package edu.android.diary;

public class Diary {

    public static final String[] TYPES={"TextOnly","TextImg"};

    private String photoPath;//사진파일경로를 담는 맴버변수
    private String txt;//일기장의 text내용을 담는 맴버변수
    private String type;

    private int year;
    private int month;
    private int day;


    public Diary(String photoPath, String txt,int year,int month,int day) {
        this.type=TYPES[0];
        this.photoPath = photoPath;
        this.txt = txt;
        this.year=year;
        this.month=month;
        this.day=day;
    }

    public Diary(String txt,int year,int month,int day) {
        this.type=TYPES[1];
        this.txt = txt;
        this.year=year;
        this.month=month;
        this.day=day;
    }


    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public String getTxt() {
        return txt;
    }
}
