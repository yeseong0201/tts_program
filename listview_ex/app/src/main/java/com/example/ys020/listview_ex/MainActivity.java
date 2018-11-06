package com.example.ys020.listview_ex;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> arGeneral = new ArrayList<>();
        arGeneral.add("Apple");
        arGeneral.add("mango");
        arGeneral.add("banana");
        arGeneral.add("oarange");
        arGeneral.add("pineapple");

        ArrayAdapter<String> Adapter;
        Adapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, arGeneral);
        ListView list = findViewById(R.id.list);
        list.setAdapter(Adapter);

    }
}
