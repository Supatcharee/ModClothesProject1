package com.example.sao.modclothesproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        /*Button btnCollection=(Button)findViewById(R.id.btnCT);
        btnCollection.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(MainMenuActivity.this, CollectionActivity.class);
                startActivity(intent);
            }
        });

        Button btnWomentStyl=(Button)findViewById(R.id.btnWS);
        btnWomentStyl.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(MainMenuActivity.this, WomanStyleActivity.class);
                startActivity(intent);
            }
        });

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
