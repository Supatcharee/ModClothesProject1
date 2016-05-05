package com.example.sao.modclothesproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.facebook.FacebookSdk;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);

        Button btnCloset=(Button)findViewById(R.id.btnCS);
        btnCloset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(MainActivity.this, ClosetActivity.class);
                startActivity(intent);
            }
        });

        ImageView imageView = (ImageView) findViewById(R.id.imageView2);
        imageView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(MainActivity.this, ClosetActivity.class);
                startActivity(intent);
            }
        });

        ImageButton imageButton = (ImageButton) findViewById(R.id.ibtnCloset);
        imageView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(MainActivity.this, ClosetActivity.class);
                startActivity(intent);
            }
        });

        Button btnCollection=(Button)findViewById(R.id.btnCT);
        btnCollection.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(MainActivity.this, CollectionsActivity.class);
                startActivity(intent);
            }
        });

       /* ImageView imageView2 = (ImageView) findViewById(R.id.imageView4);
        imageView2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(MainActivity.this, CollectionActivity.class);
                startActivity(intent);
            }
        });

        ImageButton imageButton2 = (ImageButton)findViewById(R.id.btnCollection);
        imageButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(MainActivity.this, CollectionActivity.class);
                startActivity(intent);
            }
        });*/

        Button btnWomenStyle=(Button)findViewById(R.id.btnC);
        btnWomenStyle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(MainActivity.this, WomanStyleActivity.class);
                startActivity(intent);
            }
        });

        ImageButton imageButton1 = (ImageButton)findViewById(R.id.btnWomenStyle);
        imageButton1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(MainActivity.this, WomanStyleActivity.class);
                startActivity(intent);
            }
        });
        /*
        Button btnCalendar=(Button)findViewById(R.id.btnC);
        btnCalendar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(MainMenuActivity.this, CustomCalendarView.class);
                startActivity(intent);
            }
        });

        Button btnAbout = (Button)findViewById(R.id.btnA);
        btnAbout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(MainMenuActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });*/


    }
}
