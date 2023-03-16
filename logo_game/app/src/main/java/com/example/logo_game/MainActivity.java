package com.example.logo_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button playbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playbtn=findViewById(R.id.playbtn);

        playbtn.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this, Level_activity.class);
            startActivity(intent);
            finish();
        });

    }
}