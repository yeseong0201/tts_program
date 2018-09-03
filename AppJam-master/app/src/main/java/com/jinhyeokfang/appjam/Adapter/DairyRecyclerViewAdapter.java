package com.jinhyeokfang.appjam.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jinhyeokfang.appjam.Activity.MainActivity;
import com.jinhyeokfang.appjam.Activity.ReadDairy;
import com.jinhyeokfang.appjam.Model.Dairy;
import com.jinhyeokfang.appjam.R;

import java.util.ArrayList;

public class DairyRecyclerViewAdapter extends RecyclerView.Adapter<DairyRecyclerViewAdapter.ViewHolder>{
    private ArrayList<Dairy> modelList;

    public DairyRecyclerViewAdapter (ArrayList<Dairy> modelList) {
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_dairy, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Dairy model = modelList.get(this.getItemCount() - position - 1);
        holder.title.setText(model.getTitle());
        holder.date.setText(model.getDate());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.title.getContext(), ReadDairy.class);
                intent.putExtra("title", model.getTitle());
                intent.putExtra("content", model.getContent());
                intent.putExtra("date", model.getContent());
                holder.title.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public void removeItem(int position) {
        modelList.remove(position);
        notifyItemInserted(position);
        notifyItemRangeChanged(position, this.getItemCount());
    }

    public void addItem(int position, Dairy model) {
        modelList.add(position, model);
        notifyItemInserted(position);
        notifyItemRangeChanged(position, this.getItemCount());
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView date;

        public ViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.titleTextView);
            date = view.findViewById(R.id.dateTextView);
        }
    }
}
