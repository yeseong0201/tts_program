package com.example.ys020.appple_pi_memo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class second {
    private String title;
    private String content;

    public second(String title,String content){
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
       return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}




