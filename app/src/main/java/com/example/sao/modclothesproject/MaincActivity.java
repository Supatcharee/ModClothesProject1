package com.example.sao.modclothesproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MaincActivity extends AppCompatActivity implements MyRecyclerViewAdapter.OnItemClickListener {

    private RecyclerView myRecyclerView;
    private MyRecyclerViewAdapter myRecyclerViewAdapter;
    private LinearLayoutManager linearLayoutManager;

    TextView textInfo;
    ImageView imageView;


    Button button;
    Drawable drawable;
    Bitmap bitmap;
    String ImagePath;
    Uri URI;

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

        /*btnSaveAll.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                View v1 = findViewById(android.R.id.content).getRootView();
                v1.setDrawingCacheEnabled(true);
                Bitmap bmp = Bitmap.createBitmap(v1.getDrawingCache());
                v1.setDrawingCacheEnabled(false);

                try {
                    Date d = new Date();
                    String filename  = (String) DateFormat.format("kkmmss-MMddyyyy"
                            , d.getTime());
                    File dir = new File(Environment.getExternalStorageDirectory()
                            , "/Pictures/" + filename + ".jpg");
                    FileOutputStream out = new FileOutputStream(dir);
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    bmp.compress(Bitmap.CompressFormat.JPEG, 100, bos);
                    out.write(bos.toByteArray());
                    Toast.makeText(getApplicationContext(), "Save all!"
                            , Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                }  catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
*/

        /*Button btnSaveCard = (Button) findViewById(R.id.button2);
        btnSaveCard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                View v1 = findViewById(R.id.relativeLayout);
                v1.setDrawingCacheEnabled(true);
                Bitmap bmp = Bitmap.createBitmap(v1.getDrawingCache());
                v1.setDrawingCacheEnabled(false);

                try {
                    Date d = new Date();
                    String filename  = (String)DateFormat.format("kkmmss-MMddyyyy"
                            , d.getTime());
                    File dir = new File(Environment.getExternalStorageDirectory()
                            , "/Collections/" + filename + ".png");
                    FileOutputStream out = new FileOutputStream(dir);
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    bmp.compress(Bitmap.CompressFormat.JPEG, 100, bos);
                    out.write(bos.toByteArray());
                    Toast.makeText(getApplicationContext(), "Save card!"
                            , Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }  catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });*/
    }

    private void save(){
        View v1 = findViewById(R.id.relativeLayout);
        v1.setDrawingCacheEnabled(true);
        Bitmap bmp = Bitmap.createBitmap(v1.getDrawingCache());
        v1.setDrawingCacheEnabled(false);

        try {
            Date d = new Date();
            String filename  = (String)DateFormat.format("kkmmss-MMddyyyy"
                    , d.getTime());
            File dir = new File(Environment.getExternalStorageDirectory()
                    , "/Collections/" + filename + ".png");
            FileOutputStream out = new FileOutputStream(dir);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            out.write(bos.toByteArray());
            Toast.makeText(getApplicationContext(), "Save card!"
                    , Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }  catch (IOException e) {
            e.printStackTrace();
        }

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
        String word2 = "Ac";
        String word3 = "Skirts";
        String word4 = "Dr";
        String word5 = "Pa";
        String word6 = "Shoes";
        String word7 = "Shirts";

        boolean b = word1.contains(word2);

        if(word1.contains(word7)){

            imageView = (ImageView) findViewById(R.id.info1);
            bmp = BitmapFactory.decodeFile(item.getItemUri());
            bmp = Bitmap.createScaledBitmap(bmp, 130, 500, false);
            imageView.setImageBitmap(bmp);
        }
        else if(word1.contains(word4)){
            imageView = (ImageView) findViewById(R.id.info1);
            bmp = BitmapFactory.decodeFile(item.getItemUri());
            bmp = Bitmap.createScaledBitmap(bmp, 130, 500, false);
            imageView.setImageBitmap(bmp);
        }


        else if(word1.contains(word2)){

            imageView = (ImageView) findViewById(R.id.imageView4);
            bmp = BitmapFactory.decodeFile(item.getItemUri());
            bmp = Bitmap.createScaledBitmap(bmp, 130, 500, false);
            imageView.setImageBitmap(bmp);
        }

        else if(word1.contains(word6)){

            imageView = (ImageView) findViewById(R.id.imageView6);
            bmp = BitmapFactory.decodeFile(item.getItemUri());
            bmp = Bitmap.createScaledBitmap(bmp, 130, 500, false);
            imageView.setImageBitmap(bmp);
        }

        }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.collection, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.edit) {
            Intent i = new Intent(MaincActivity.this, InsertsMeasurementsActivity.class);
            startActivity(i);
        }

        if (id == R.id.home) {
            Intent i = new Intent(MaincActivity.this, MainActivity.class);
            startActivity(i);
        }

        if (id == R.id.save) {
            save();
            Intent i = new Intent(MaincActivity.this, CollectionsActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);

    }


    }



