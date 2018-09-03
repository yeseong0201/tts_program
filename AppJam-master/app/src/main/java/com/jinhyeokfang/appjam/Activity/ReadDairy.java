package com.jinhyeokfang.appjam.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.jinhyeokfang.appjam.R;

public class ReadDairy extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        Intent intent = getIntent();
        String title = intent.getExtras().getString("title");
        String date = intent.getExtras().getString("date");
        String content = intent.getExtras().getString("content");

        TextView titleTextView = findViewById(R.id.readTitleTextView);
        TextView dateTextView = findViewById(R.id.readDateTextView);
        TextView contentTextView = findViewById(R.id.readContentTextView2);

        titleTextView.setText(title);
        dateTextView.setText(date);
        contentTextView.setText(content);
    }
}
