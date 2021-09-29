package com.example.movieworkshoptemplate.models;

import java.util.Random;

//Movie POJO
public class Movie {

    private int year;
    private int length;
    private String title;
    private String subject;
    private int popularity;
    private boolean awards;

    public Movie(int year, int length, String title, String subject, int popularity, boolean awards) {
        this.year = year;
        this.length = length;
        this.title = title;
        this.subject = subject;
        this.popularity = popularity;
        this.awards = awards;
    }

    public int getYear() {
        return year;
    }

    public int getLength() {
        return length;
    }

    public String getTitle() {
        return title;
    }

    public String getSubject() {
        return subject;
    }

    public int getPopularity() {
        return popularity;
    }

    public boolean isAwards() {
        return awards;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public void setAwards(boolean awards) {
        this.awards = awards;
    }

    @Override
    public String toString() {
        return
                "year=" + year +
                        ", length=" + length +
                        ", title='" + title + '\'' +
                        ", subject='" + subject + '\'' +
                        ", popularity=" + popularity +
                        ", awards=" + awards +
                        "<br>" +
                        '}';
    }

    public static int randInt (int min, int max){
        Random rand = new Random();
        return rand.nextInt((max - min) +1) + min;
    }

}
