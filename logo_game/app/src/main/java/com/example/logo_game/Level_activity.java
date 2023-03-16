package com.example.logo_game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

public class Level_activity extends AppCompatActivity {
    int[] imgs={R.drawable.green_circle,R.drawable.yellow_circle,R.drawable.flaga_us_locked,R.drawable.red_circle,
            R.drawable.red_circle,R.drawable.flaga_retro_locked,R.drawable.red_circle,R.drawable.flaga_us_locked,
            R.drawable.red_circle,R.drawable.flaga_retro_locked,R.drawable.red_circle,R.drawable.flaga_us_locked,
            R.drawable.red_circle,R.drawable.flaga_retro_locked,R.drawable.red_circle,R.drawable.flaga_internet_locked};
    String[] levels={"Level 1","Level 2","USA","Level 3","Level 4","Retro","Level 5","USA 2",
            "Level 6","Retro 2","Level 7","USA 3","Level 8","Retro 3","Level 9","Internet"};

    RecyclerView recyclerView;
    Level_Adapter level_adapter;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        recyclerView=findViewById(R.id.recyclerview);
        Level_Adapter levelAdapter=new Level_Adapter(this,imgs,levels);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(Level_activity.this);
        linearLayoutManager.setOrientation(recyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(levelAdapter);
    }
}