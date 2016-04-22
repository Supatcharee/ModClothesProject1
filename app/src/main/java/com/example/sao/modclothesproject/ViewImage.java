package com.example.sao.modclothesproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class ViewImage extends AppCompatActivity {

    ImageView imageview;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_image);

        Intent i = getIntent();

        // Get the position
        int position = i.getExtras().getInt("position");

        // Get String arrays FilePathStrings
        String[] filepath = i.getStringArrayExtra("filepath");

        // Get String arrays FileNameStrings
        String[] filename = i.getStringArrayExtra("filename");

        // Locate the TextView in view_image.xml
        //text = (TextView) findViewById(R.id.imagetext);

        // Load the text into the TextView followed by the position
        //text.setText(filepath[position]);

        // Locate the ImageView in view_image.xml
        imageview = (ImageView) findViewById(R.id.full_image_view);

        // Decode the filepath with BitmapFactory followed by the position
        Bitmap bmp = BitmapFactory.decodeFile(filepath[position]);

        // Set the decoded bitmap into ImageView
        imageview.setImageBitmap(bmp);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent i = getIntent();

                // Get the position
                int position = i.getExtras().getInt("position");

                // Get String arrays FilePathStrings
                String[] filepath = i.getStringArrayExtra("filepath");

                File file = new File(filepath[position]);
                file.delete();
                Intent intent = new Intent(ViewImage.this, ClosetActivity.class);
                startActivity(intent);
            }
        });
    }
}
