package com.example.ys020.open_with_intent;

import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String text01;
    String edit01;
    int btnCall;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
       text01 = (TextView) findViewById(R.id.sadf);
        super.onCreate(savedInstanceState);
    }



}
