package com.example.sao.modclothesproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.File;

public class CreateCollectionActivity extends AppCompatActivity {
    private String[] FilePathStrings;
    private String[] FileNameStrings;
    private File[] listFile;
    LinearLayout linearLayout;
    GridView grid;
    GridViewAdapter adapter;
    File file;
    private int[] imagesId = {R.mipmap.bbb, R.mipmap.body};
    private ImageView imgOldSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_collection);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        LinearLayout gallery = (LinearLayout) findViewById(R.id.images_gallery);
        final ImageView imgFullSize = (ImageView) findViewById(R.id.imageView7);


        for (int id : imagesId) {
            ImageView image = new ImageView(this);
            image.setLayoutParams(new LinearLayout.LayoutParams(150, 150));
            image.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            image.setPadding(8, 8, 8, 8);
            image.setImageResource(id);
            image.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    ImageView imgSelected = (ImageView) v;
                    Bitmap bitmap = ((BitmapDrawable) imgSelected.getDrawable()).getBitmap();
                    imgFullSize.setImageBitmap(bitmap);

                    if (imgOldSelected != null) {
                        imgOldSelected.setBackgroundColor(Color.TRANSPARENT);
                    }
                    imgSelected.setBackgroundColor(Color.YELLOW);
                    imgOldSelected = imgSelected;
                }
            });

            gallery.addView(image);
        }
    }
}