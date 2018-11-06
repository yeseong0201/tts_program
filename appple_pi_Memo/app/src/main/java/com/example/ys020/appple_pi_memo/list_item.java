package com.example.ys020.appple_pi_memo;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class list_item extends BaseAdapter {
    ArrayList<Data> items;
    LayoutInflater inflater;
    public ListAdapter(ArrayList<Data> items, Context context){
        this.items = items;
        this.inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = inflater.inflate(R.layout.activity_list_item,viewGroup,false);
        }
        Data listItem = items.get(i);

        TextView title = view.findViewById(R.id.itemTitle);
        title.setText(listItem.getTitle());

        TextView contents = view.findViewById(R.id.itemContents);
        contents.setText(listItem.getContents());


        return view;
    }
}
