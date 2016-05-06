package com.example.sao.modclothesproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

public class CollectionViewActivity extends AppCompatActivity {

    ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection_view);

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
                Intent intent = new Intent(CollectionViewActivity.this, ClosetActivity.class);
                startActivity(intent);
            }
        });
        /*Button btnEdit = (Button) findViewById(R.id.btnEdit);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                //Intent imageIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

                File imagesFolder = new File(Environment.getExternalStorageDirectory(), "MOD Images");

                imagesFolder.mkdirs();

                Log.e("sao_project_2_test", "" + imagesFolder.exists());

                File image = new File(imagesFolder, "Im_" + timeStamp + ".png");

                Uri uriSavedImage = Uri.fromFile(image);

                intent.putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage);
                startActivityForResult(intent, TAKE_PICTURE);


            }
        });*/

        Button btnHome = (Button) findViewById(R.id.btnEdit);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CollectionViewActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

        Button btnCancel = (Button) findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CollectionViewActivity.this, ClosetActivity.class);
                startActivity(intent);

            }
        });
       /* Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                LinearLayout llAttendeeList = (LinearLayout) findViewById(R.id.linear);
                llAttendeeList.setDrawingCacheEnabled(true);
                Bitmap bitmap = llAttendeeList.getDrawingCache();
                File file, f = null;
                if (android.os.Environment.getExternalStorageState().equals(
                        android.os.Environment.MEDIA_MOUNTED)) {
                    file = new File(
                            android.os.Environment.getExternalStorageDirectory(),
                            "myfolder");
                    if (!file.exists()) {
                        file.mkdirs();

                    }
                    f = new File(file.getAbsolutePath() + file.separator + "filename"
                            + ".png");
                }
                FileOutputStream ostream = null;
                try {
                    ostream = new FileOutputStream(f);
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                bitmap.compress(Bitmap.CompressFormat.PNG, 10, ostream);
                try {
                    ostream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });*/









    }
}
