package com.example.cook_book;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Item_Adapter extends RecyclerView.Adapter<Item_Adapter.View_Holder> {
    int[] imgs;
    String[] item;
    Activity activity;
    public Item_Adapter(Activity activity, int[] imgs, String[] item) {
        this.activity=activity;
        this.imgs=imgs;
        this.item=item;
    }

    @NonNull
    @Override
    public View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(activity).inflate(R.layout.item_receipe,parent,false);
        View_Holder view_holder=new View_Holder(view);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull View_Holder holder, int position) {
            holder.img.setImageResource(imgs[position]);
            holder.txt.setText(item[position]);
            holder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(activity,Recipe_Activity.class);
                    intent.putExtra("Items",item);
                    activity.startActivity(intent);
                }
            });
    }

    @Override
    public int getItemCount() {
        return imgs.length;
    }

    public class View_Holder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt;
        public View_Holder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            txt=itemView.findViewById(R.id.txt);
        }
    }
}
