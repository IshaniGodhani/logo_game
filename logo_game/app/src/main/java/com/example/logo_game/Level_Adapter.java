package com.example.logo_game;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Level_Adapter extends RecyclerView.Adapter<Level_Adapter.View_Holder> {
    Activity activity;
    int[] imgs;
    String[] levels;
    public Level_Adapter(Activity activity, int[] imgs, String[] levels) {
        this.activity=activity;
        this.imgs=imgs;
        this.levels=levels;
    }

    @NonNull
    @Override
    public View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(activity).inflate(R.layout.levels_category,parent,false);
        View_Holder view_holder=new View_Holder(view);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull View_Holder holder, int position) {
        holder.levelimg.setImageResource(imgs[position]);
        holder.level.setText(levels[position]);
        holder.level.setOnClickListener(v -> {
            Intent intent=new Intent(activity,logo_activity.class);
            intent.putExtra("Levels",levels);
            activity.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return imgs.length;
    }

    public class View_Holder extends RecyclerView.ViewHolder {
        TextView level;
        ImageView levelimg;
        public View_Holder(@NonNull View itemView) {
            super(itemView);
            level=itemView.findViewById(R.id.leveltxt);
            levelimg=itemView.findViewById(R.id.levelimg);
        }
    }
}
