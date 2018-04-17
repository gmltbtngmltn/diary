package edu.android.diary;

public class Diary {
    private int photoId;//갤러리에서 받아온 사진파일을 바이너리 형식이든 파일명이든 어떤형식으로든 사진파일 정보를 담는 맴버변수
                          //지금은 임시로 int로 해놓음
    private String txt; //일기장의 text내용을 담는 맴버변수

    public Diary(int photoId, String txt) {
        this.photoId = photoId;
        this.txt = txt;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public int getPhotoId() {
        return photoId;
    }

    public String getTxt() {
        return txt;
    }
}
