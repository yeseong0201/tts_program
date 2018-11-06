package com.example.ys020.suk_je;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Date;

public class list_item extends AppCompatActivity {
    private int profile;
    private Date date;
    private String nickname;
    private String content;
    private String title_view;


    public list_item(int profile, Date date, String nickname, String content, String title_view) {
        this.profile = profile;
        this.date = date;
        this.nickname = nickname;
        this.content = content;
        this.title_view = title_view;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle_view() {
        return title_view;
    }

    public void setTitle_view(String title_view) {
        this.title_view = title_view;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
    }
}
