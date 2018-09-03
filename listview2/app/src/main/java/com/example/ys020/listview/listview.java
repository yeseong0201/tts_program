package com.example.ys020.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class listview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        String[] items = {"정보보호과","소프트웨어과","테크노경영과","멀티미디어과"};
        ListAdapter adapter = new ArrayAdapter<String>(this,android.R.layout. simple_list_item_1);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setOnClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void  onItemClick(AdapterView<?> parent. View view, int i, long id){
String items = String.valueOf(parent.getItemAtPosition(i));
                        Toast.makeText(MainActivity.this)
                    }
                }
        )

            @Override
                    public void onItemsClick(AdapterView<?> parent)
        };
    }
}
