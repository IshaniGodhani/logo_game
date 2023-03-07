package com.example.cook_book;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

public class Recipe_Activity extends AppCompatActivity {
    int[] p_imgs={R.drawable.asian,R.drawable.beaf,R.drawable.chilled,R.drawable.company,
            R.drawable.crockpot2,R.drawable.greekstyle,R.drawable.mexican,R.drawable.oldfashiond};
    String[] p_items={"Asian pasta","Beaf barely stew","Chilled pasta","Company pasta",
    "Crockpot lasagna","Greek Style Pasta","Mexican Pasta","Old Fashionad Pudding"};
    RecyclerView recyclerView;
    Receipe_Adapter receipe_adapter;
    String[] items;
    int pos;
    TextView label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        recyclerView=findViewById(R.id.gridview);
        receipe_adapter=new Receipe_Adapter(this,p_imgs,p_items);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(Recipe_Activity.this,2);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(receipe_adapter);

        label=findViewById(R.id.label);
        pos=getIntent().getIntExtra("pos",0);
        items=getIntent().getStringArrayExtra("Items");
        label.setText(items[pos]);

    }
}