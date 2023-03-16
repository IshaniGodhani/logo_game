package com.example.logo_game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class logo_activity extends AppCompatActivity {
    RecyclerView recyclerView;
    Logo_Adapter logo_adapter;
    TextView levelnum;
    int numOfImage;
    ArrayList<String> imgList=new ArrayList<>();
    String[] levels;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        recyclerView=findViewById(R.id.gridview);
        String[] images = new String[0];
        try {
            images = getAssets().list("pre_logo");
            imgList = new ArrayList<String>(Arrays.asList(images));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logo_adapter=new Logo_Adapter(this,imgList);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(logo_activity.this,3);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(logo_adapter);

        levelnum=findViewById(R.id.levelnum);
        pos=getIntent().getIntExtra("pos",0);
        levels=getIntent().getStringArrayExtra("Levels");
        levelnum.setText(levels[pos]);
    }
}