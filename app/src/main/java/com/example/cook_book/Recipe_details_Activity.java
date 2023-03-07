package com.example.cook_book;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class Recipe_details_Activity extends AppCompatActivity {
    ImageView main_img,share,coppy,download;
    TextView main_txt;
    int pos;
    String[] items_arr;
    int[] images_arr;
    File f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);
        main_img = findViewById(R.id.main_img);
        main_txt = findViewById(R.id.main_txt);
        share = findViewById(R.id.share);
        coppy = findViewById(R.id.coppy);
        download = findViewById(R.id.download);

        pos=getIntent().getIntExtra("pos",pos);
        items_arr=getIntent().getStringArrayExtra("items_arr");
        images_arr=getIntent().getIntArrayExtra("images_arr");

        main_img.setImageResource(images_arr[pos]);
        main_txt.setText(items_arr[pos]);
        coppy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager cm = (ClipboardManager)getApplicationContext().getSystemService(Context.CLIPBOARD_SERVICE);
                cm.setText(main_img.toString());
                Toast.makeText(getApplicationContext(), "Copied :)", Toast.LENGTH_SHORT).show();
            }
        });
        download.setOnClickListener(v -> {
            Bitmap icon = getBitmapFromView(main_img);
            //Intent share = new Intent(Intent.ACTION_SEND);
            Intent share =new Intent(Intent.ACTION_SEND);
            share.setType("image/jpeg");
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            icon.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
            int num=new Random().nextInt(2000);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
            String currentDateandTime = sdf.format(new Date());

            f= new File(config.file.getAbsolutePath() + "/IMG_"+currentDateandTime+".jpg");
            try
            {
                f.createNewFile();
                FileOutputStream fo = new FileOutputStream(f);
                fo.write(bytes.toByteArray());
                Toast.makeText(Recipe_details_Activity.this,"File Downloaded",Toast.LENGTH_SHORT).show();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        });
        share.setOnClickListener(v -> {
            Bitmap icon = getBitmapFromView(main_img);
            //Intent share = new Intent(Intent.ACTION_SEND);
            Intent share =new Intent(Intent.ACTION_SEND);
            share.setType("image/jpeg");
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            icon.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
            int num=new Random().nextInt(2000);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
            String currentDateandTime = sdf.format(new Date());

            f= new File(config.file.getAbsolutePath() + "/IMG_"+currentDateandTime+".jpg");
            try
            {
                f.createNewFile();
                FileOutputStream fo = new FileOutputStream(f);
                fo.write(bytes.toByteArray());
                Toast.makeText(Recipe_details_Activity.this,"File Downloaded",Toast.LENGTH_SHORT).show();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            share.putExtra(Intent.EXTRA_STREAM, Uri.parse(f.getAbsolutePath()));
            startActivity(Intent.createChooser(share, "Share Image"));
        });
    }

    private Bitmap getBitmapFromView(ImageView main_img) {
          Bitmap returnedBitmap = Bitmap.createBitmap(main_img.getWidth(), main_img.getHeight(), Bitmap.Config.ARGB_8888);
        //Bind a canvas to it
        Canvas canvas = new Canvas(returnedBitmap);
        //Get the view's background
        Drawable bgDrawable = main_img.getBackground();
        if (bgDrawable != null)
        {
            //has background drawable, then draw it on the canvas
            bgDrawable.draw(canvas);
        }
        else
        {
            //does not have background drawable, then draw white background on the canvas
            canvas.drawColor(Color.WHITE);
        }
        // draw the view on the canvas
        main_img.draw(canvas);
        //return the bitmap
        return returnedBitmap;
    }
}