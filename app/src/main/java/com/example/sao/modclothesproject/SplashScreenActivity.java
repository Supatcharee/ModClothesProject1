package com.example.sao.modclothesproject;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {
    private static final int REFRESH_SCREEN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        startSplashScreen();
    }

    public void startSplashScreen() {
        new Thread() {
            public void run() {
                try{
                    Thread.sleep(500);
                    hRefresh.sendEmptyMessage(REFRESH_SCREEN);
                }catch(Exception e){
                }
            }
        }.start();
    }

    Handler hRefresh = new Handler(){
        public void handleMessage(Message msg) {
            switch(msg.what){
                case REFRESH_SCREEN:

                    // Open MainActivity
                    Intent newActivity = new Intent(SplashScreenActivity.this,MainActivity.class);
                    startActivity(newActivity);

                    break;
                default:
                    break;
            }
        }
    };

}
