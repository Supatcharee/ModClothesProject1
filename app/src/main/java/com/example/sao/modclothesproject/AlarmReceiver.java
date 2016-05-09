package com.example.sao.modclothesproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Sao on 5/9/2016.
 */
public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context arg0, Intent arg1) {
        Toast.makeText(arg0, "Alarm received!22222222222222222222222222222222222222222222222222222", Toast.LENGTH_LONG).show();
    }


}
