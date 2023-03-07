package com.example.cook_book;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Item_Adapter item_adapter;
    int[] imgs={R.drawable.pasta,R.drawable.crockpot,R.drawable.rice,R.drawable.salads,
            R.drawable.vegetarian,R.drawable.juice,R.drawable.smoothies,
            R.drawable.desserts,R.drawable.cake,R.drawable.dinner,R.drawable.snacks};
    String[] item={"Pasta Reciepie","Crockpot Reciepie","Rice Reciepie","Salad Reciepie",
            "Vegetarian Reciepie","juice Reciepie","Smoothies","Desserts",
            "Cakes","Dinner","Snacks"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        item_adapter=new Item_Adapter(this,imgs,item);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(item_adapter);
    }
}