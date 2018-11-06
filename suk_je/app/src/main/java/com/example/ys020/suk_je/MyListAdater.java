package com.example.ys020.suk_je;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;



    public class MyListAdater extends BaseAdapter{
        Context context;
        ArrayList<list_item> list_itemArrayList;

        public MyListAdater(Context context, ArrayList<list_item> list_itemArrayList) {
            this.context = context;
            this.list_itemArrayList = list_itemArrayList;
        }

        @Override
        public int getCount() {
            this.list_itemArrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return list_itemArrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertview, ViewGroup parent) {
            if (convertview == null){
                convertview =
                        LayoutInflater.from(context).inflate(R.layout.activity_item,null);
            }
          return  convertview;
        }
    }

