package com.example.cook_book;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Receipe_Adapter extends RecyclerView.Adapter<Receipe_Adapter.View_holder> {
    Context context;
    int[] p_imgs;
    String[] p_items;
    public Receipe_Adapter(Context context, int[] p_imgs, String[] p_items) {
        this.p_imgs=p_imgs;
        this.p_items=p_items;
        this.context=context;
    }

    @NonNull
    @Override
    public View_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.receipe_category,parent,false);
        View_holder view_holder=new View_holder(view);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull View_holder holder, int position) {
        holder.re_img.setImageResource(p_imgs[position]);
        holder.re_txt.setText(p_items[position]);
        holder.re_img.setOnClickListener(v -> {
            Intent intent=new Intent(context,Recipe_details_Activity.class);
            intent.putExtra("pos",holder.getAdapterPosition());
            intent.putExtra("images_arr",p_imgs);
            intent.putExtra("items_arr",p_items);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return p_imgs.length;
    }

    public class View_holder extends RecyclerView.ViewHolder {
        ImageView re_img;
        TextView re_txt;
        public View_holder(@NonNull View itemView) {
            super(itemView);
            re_img=itemView.findViewById(R.id.re_img);
            re_txt=itemView.findViewById(R.id.re_txt);
        }
    }
}
