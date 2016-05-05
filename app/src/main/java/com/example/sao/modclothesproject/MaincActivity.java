package com.example.sao.modclothesproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MaincActivity extends AppCompatActivity implements MyRecyclerViewAdapter.OnItemClickListener {

    private RecyclerView myRecyclerView;
    private MyRecyclerViewAdapter myRecyclerViewAdapter;
    private LinearLayoutManager linearLayoutManager;

    TextView textInfo;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainc);
        textInfo = (TextView) findViewById(R.id.info);
        textInfo.setMovementMethod(new ScrollingMovementMethod());

        myRecyclerView = (RecyclerView) findViewById(R.id.myrecyclerview);
        linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        myRecyclerViewAdapter = new MyRecyclerViewAdapter(this, this);
        myRecyclerViewAdapter.setOnItemClickListener(this);
        myRecyclerView.setAdapter(myRecyclerViewAdapter);
        myRecyclerView.setLayoutManager(linearLayoutManager);

        imageView = (ImageView) findViewById(R.id.imageView4);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRecyclerViewAdapter.clearAll();
                prepareGalleryimage4();
            }
        });

        imageView = (ImageView) findViewById(R.id.info1);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRecyclerViewAdapter.clearAll();
                prepareGalleryinfo();
            }
        });

        imageView = (ImageView) findViewById(R.id.imageView5);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRecyclerViewAdapter.clearAll();
                prepareGalleryimage5();
            }
        });

        imageView = (ImageView) findViewById(R.id.imageView6);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRecyclerViewAdapter.clearAll();
                prepareGalleryimage6();
            }
        });

        Button button = (Button)findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelativeLayout relativeLayout=(RelativeLayout)findViewById(R.id.relativeLayout);
                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

                File imagesFolder = new File(Environment.getExternalStorageDirectory(), "Collections");

                imagesFolder.mkdirs();

                Log.e("sao_project_2_test", "" + imagesFolder.exists());

                File image = new File(imagesFolder, "Im_" + timeStamp + ".png");

                Uri uriSavedImage = Uri.fromFile(image);


            }
        });

    }
    private void prepareGalleryinfo(){
        String ExternalStorageDirectoryPath = Environment
                .getExternalStorageDirectory()
                .getAbsolutePath();
        String targetPath = ExternalStorageDirectoryPath + "/Dress/";

        Toast.makeText(getApplicationContext(), targetPath, Toast.LENGTH_LONG).show();
        File targetDirector = new File(targetPath);

        File[] files = targetDirector.listFiles();
        for (File file : files){
            Uri uri = Uri.fromFile(file);
            myRecyclerViewAdapter.add(
                    myRecyclerViewAdapter.getItemCount(),
                    uri);

        }
    }

    private void prepareGalleryimage4(){
        String ExternalStorageDirectoryPath = Environment
                .getExternalStorageDirectory()
                .getAbsolutePath();
        String targetPath = ExternalStorageDirectoryPath + "/Accessories/";

        Toast.makeText(getApplicationContext(), targetPath, Toast.LENGTH_LONG).show();
        File targetDirector = new File(targetPath);

        File[] files = targetDirector.listFiles();
        for (File file : files){
            Uri uri = Uri.fromFile(file);
            myRecyclerViewAdapter.add(
                    myRecyclerViewAdapter.getItemCount(),
                    uri);

        }
    }

    private void prepareGalleryimage5(){
        String ExternalStorageDirectoryPath = Environment
                .getExternalStorageDirectory()
                .getAbsolutePath();
        String targetPath = ExternalStorageDirectoryPath + "/Accessories/";

        Toast.makeText(getApplicationContext(), targetPath, Toast.LENGTH_LONG).show();
        File targetDirector = new File(targetPath);

        File[] files = targetDirector.listFiles();
        for (File file : files){
            Uri uri = Uri.fromFile(file);
            myRecyclerViewAdapter.add(
                    myRecyclerViewAdapter.getItemCount(),
                    uri);

        }
    }

    private void prepareGalleryimage6(){
        String ExternalStorageDirectoryPath = Environment
                .getExternalStorageDirectory()
                .getAbsolutePath();
        String targetPath = ExternalStorageDirectoryPath + "/Shoes/";

        Toast.makeText(getApplicationContext(), targetPath, Toast.LENGTH_LONG).show();
        File targetDirector = new File(targetPath);

        File[] files = targetDirector.listFiles();
        for (File file : files){
            Uri uri = Uri.fromFile(file);
            myRecyclerViewAdapter.add(
                    myRecyclerViewAdapter.getItemCount(),
                    uri);

        }
    }



    @Override
    public void onItemClick(MyRecyclerViewAdapter.ItemHolder item, int position) {
        Bitmap bmp;

        String stringitemUri = item.getItemUri();
        Toast.makeText(MaincActivity.this, stringitemUri, Toast.LENGTH_SHORT).show();

                /*imageView = (ImageView) findViewById(R.id.info1);
                bmp = BitmapFactory.decodeFile(item.getItemUri());
                bmp = Bitmap.createScaledBitmap(bmp, 130, 500, false);
                imageView.setImageBitmap(bmp);*/
        String word1 = item.getItemUri();
        String word2 = "IMG";
        String word3 = "Co";
        boolean b = word1.contains(word2);

        if(word1.contains(word2)){

            imageView = (ImageView) findViewById(R.id.info1);
            bmp = BitmapFactory.decodeFile(item.getItemUri());
            bmp = Bitmap.createScaledBitmap(bmp, 130, 500, false);
            imageView.setImageBitmap(bmp);
        }
        else if(word1.contains(word3)){

            imageView = (ImageView) findViewById(R.id.imageView5);
            bmp = BitmapFactory.decodeFile(item.getItemUri());
            bmp = Bitmap.createScaledBitmap(bmp, 130, 500, false);
            imageView.setImageBitmap(bmp);
        }

        }



    }



