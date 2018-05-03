package edu.android.diary;

import java.io.Serializable;

public class NoteSI implements Serializable{

    private String content;

    private int year;
    private int month;
    private int day;

    public NoteSI() {}

    public NoteSI(String content, int year, int month, int day) {
        this.content = content;
        this.year = year;
        this.month = month;
        this.day = day;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
