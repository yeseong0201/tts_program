package com.jinhyeokfang.appjam.Model;

public class Dairy {
    public String title;
    public String content;
    public String date;

    public Dairy (String title, String content, String date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public String getTitle() { return title; }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }
}
