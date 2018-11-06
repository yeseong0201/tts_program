package com.example.ys020.spinner_ex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    ArrayAdapter<CharSequence> adspin;
    boolean mIninSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spin = (Spinner) findViewById(R.id.);
        String promptText = getString(R.string.ptext);
        spin.setPrompt(promptText);
        adspin = ArrayAdapter.createFromResource
                (this, R.array.colors,)

    }
}
