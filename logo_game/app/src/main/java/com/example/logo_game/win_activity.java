package com.example.logo_game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class win_activity extends AppCompatActivity {
    TextView textView;
    Button btn;
    ViewPager viewPager;
    ArrayList<String> imgList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        viewPager=findViewById(R.id.win_viewpage);
        btn=findViewById(R.id.next);
        textView=findViewById(R.id.ans);
        String[] images = new String[0];
        try {
            images = getAssets().list("post_logo");
            imgList = new ArrayList<String>(Arrays.asList(images));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(win_activity.this,Quiz_Activity.class);
                startActivity(intent);
            }
        });
    }
}