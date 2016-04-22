package com.example.sao.modclothesproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WomanStyleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_woman_style);

        Button btnPear =(Button)findViewById(R.id.btnPear);
        btnPear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(WomanStyleActivity.this, PareShapeActivity.class);
                startActivity(intent);
            }
        });

        Button btnApple =(Button)findViewById(R.id.btnApple);
        btnApple.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(WomanStyleActivity.this, AppleShapeActivity.class);
                startActivity(intent);
            }
        });

        Button btnHourGlass =(Button)findViewById(R.id.btnHourGlass);
        btnHourGlass.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(WomanStyleActivity.this, HourglassShapeActivity.class);
                startActivity(intent);
            }
        });

        Button btnRectangle =(Button)findViewById(R.id.btnRectangle);
        btnRectangle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(WomanStyleActivity.this, RectangleActivity.class);
                startActivity(intent);
            }
        });
    }
}
