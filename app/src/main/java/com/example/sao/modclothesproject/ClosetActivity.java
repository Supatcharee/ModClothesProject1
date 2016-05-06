package com.example.sao.modclothesproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClosetActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final int TAKE_PICTURE = 1;

    private String[] FilePathStrings;
    private String[] FileNameStrings;
    private File[] listFile;
    GridView grid;
    GridViewAdapter adapter;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_closet);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Check for SD Card
        if (!Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            Toast.makeText(this, "Error! No SDCARD Found!", Toast.LENGTH_LONG)
                    .show();
        } else {
            // Locate the image folder in your SD Card
            file = new File(Environment.getExternalStorageDirectory()
                    + File.separator + "MOD Images");
            // Create a new folder if no folder named SDImageTutorial exist
            file.mkdirs();
        }

        if (file.isDirectory()) {
            listFile = file.listFiles();
            // Create a String array for FilePathStrings
            FilePathStrings = new String[listFile.length];
            // Create a String array for FileNameStrings
            FileNameStrings = new String[listFile.length];

            for (int i = 0; i < listFile.length; i++) {
                // Get the path of the image file
                FilePathStrings[i] = listFile[i].getAbsolutePath();
                // Get the name image file
                FileNameStrings[i] = listFile[i].getName();
            }
        }

        // Locate the GridView in gridview_main.xml
        grid = (GridView) findViewById(R.id.gridView);
        // Pass String arrays to LazyAdapter Class
        adapter = new GridViewAdapter(this, FilePathStrings, FileNameStrings);
        // Set the LazyAdapter to the GridView
        grid.setAdapter(adapter);

        // Capture gridview item click
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent i = new Intent(ClosetActivity.this, ViewImage.class);
                // Pass String arrays FilePathStrings
                i.putExtra("filepath", FilePathStrings);
                // Pass String arrays FileNameStrings
                i.putExtra("filename", FileNameStrings);
                // Pass click position
                i.putExtra("position", position);
                startActivity(i);
            }

        });
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.closet, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.camera) {

// location found
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                //Intent imageIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

                File imagesFolder = new File(Environment.getExternalStorageDirectory(), "Collections");

                imagesFolder.mkdirs();

                Log.e("sao_project_2_test", "" + imagesFolder.exists());

                File image = new File(imagesFolder, "Im_" + timeStamp + ".png");

                Uri uriSavedImage = Uri.fromFile(image);

                intent.putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage);
                startActivityForResult(intent, TAKE_PICTURE);
        }

        if (id == R.id.home) {
            Intent i = new Intent(ClosetActivity.this, MainActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        /*if (id == R.id.nav_home) {
            // Handle the camera action

            // Check for SD Card
            if (!Environment.getExternalStorageState().equals(
                    Environment.MEDIA_MOUNTED)) {
                Toast.makeText(this, "Error! No SDCARD Found!", Toast.LENGTH_LONG)
                        .show();
            } else {
                // Locate the image folder in your SD Card
                file = new File(Environment.getExternalStorageDirectory()
                        + File.separator + "MOD Images");
                // Create a new folder if no folder named SDImageTutorial exist
                file.mkdirs();
            }

            if (file.isDirectory()) {
                listFile = file.listFiles();
                // Create a String array for FilePathStrings
                FilePathStrings = new String[listFile.length];
                // Create a String array for FileNameStrings
                FileNameStrings = new String[listFile.length];

                for (int i = 0; i < listFile.length; i++) {
                    // Get the path of the image file
                    FilePathStrings[i] = listFile[i].getAbsolutePath();
                    // Get the name image file
                    FileNameStrings[i] = listFile[i].getName();
                }
            }

            // Locate the GridView in gridview_main.xml
            grid = (GridView) findViewById(R.id.gridView);
            // Pass String arrays to LazyAdapter Class
            adapter = new GridViewAdapter(this, FilePathStrings, FileNameStrings);
            // Set the LazyAdapter to the GridView
            grid.setAdapter(adapter);

            // Capture gridview item click
            grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {

                    Intent i = new Intent(ClosetActivity.this, ViewImage.class);
                    // Pass String arrays FilePathStrings
                    i.putExtra("filepath", FilePathStrings);
                    // Pass String arrays FileNameStrings
                    i.putExtra("filename", FileNameStrings);
                    // Pass click position
                    i.putExtra("position", position);
                    startActivity(i);
                }

            });

        }else*/ if (id == R.id.nav_shirts) {
            // Handle the camera action

            // Check for SD Card
            if (!Environment.getExternalStorageState().equals(
                    Environment.MEDIA_MOUNTED)) {
                Toast.makeText(this, "Error! No SDCARD Found!", Toast.LENGTH_LONG)
                        .show();
            } else {
                // Locate the image folder in your SD Card
                file = new File(Environment.getExternalStorageDirectory()
                        + File.separator + "Shirts");
                // Create a new folder if no folder named SDImageTutorial exist
                file.mkdirs();
            }

            if (file.isDirectory()) {
                listFile = file.listFiles();
                // Create a String array for FilePathStrings
                FilePathStrings = new String[listFile.length];
                // Create a String array for FileNameStrings
                FileNameStrings = new String[listFile.length];

                for (int i = 0; i < listFile.length; i++) {
                    // Get the path of the image file
                    FilePathStrings[i] = listFile[i].getAbsolutePath();
                    // Get the name image file
                    FileNameStrings[i] = listFile[i].getName();
                }
            }

            // Locate the GridView in gridview_main.xml
            grid = (GridView) findViewById(R.id.gridView);
            // Pass String arrays to LazyAdapter Class
            adapter = new GridViewAdapter(this, FilePathStrings, FileNameStrings);
            // Set the LazyAdapter to the GridView
            grid.setAdapter(adapter);

            // Capture gridview item click
            grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {

                    Intent i = new Intent(ClosetActivity.this, ViewImage.class);
                    // Pass String arrays FilePathStrings
                    i.putExtra("filepath", FilePathStrings);
                    // Pass String arrays FileNameStrings
                    i.putExtra("filename", FileNameStrings);
                    // Pass click position
                    i.putExtra("position", position);
                    startActivity(i);
                }

            });


                    Intent intent = new Intent(ClosetActivity.this, ShitsActivity.class);
                    startActivity(intent);


        } else if (id == R.id.nav_pants) {
            /*// Check for SD Card
            if (!Environment.getExternalStorageState().equals(
                    Environment.MEDIA_MOUNTED)) {
                Toast.makeText(this, "Error! No SDCARD Found!", Toast.LENGTH_LONG)
                        .show();
            } else {
                // Locate the image folder in your SD Card
                file = new File(Environment.getExternalStorageDirectory()
                        + File.separator + "Pants");
                // Create a new folder if no folder named SDImageTutorial exist
                file.mkdirs();
            }

            if (file.isDirectory()) {
                listFile = file.listFiles();
                // Create a String array for FilePathStrings
                FilePathStrings = new String[listFile.length];
                // Create a String array for FileNameStrings
                FileNameStrings = new String[listFile.length];

                for (int i = 0; i < listFile.length; i++) {
                    // Get the path of the image file
                    FilePathStrings[i] = listFile[i].getAbsolutePath();
                    // Get the name image file
                    FileNameStrings[i] = listFile[i].getName();
                }
            }

            // Locate the GridView in gridview_main.xml
            grid = (GridView) findViewById(R.id.gridView);
            // Pass String arrays to LazyAdapter Class
            adapter = new GridViewAdapter(this, FilePathStrings, FileNameStrings);
            // Set the LazyAdapter to the GridView
            grid.setAdapter(adapter);

            // Capture gridview item click
            grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {

                    Intent i = new Intent(ClosetActivity.this, ViewImage.class);
                    // Pass String arrays FilePathStrings
                    i.putExtra("filepath", FilePathStrings);
                    // Pass String arrays FileNameStrings
                    i.putExtra("filename", FileNameStrings);
                    // Pass click position
                    i.putExtra("position", position);
                    startActivity(i);
                }

            });*/

            Intent intent = new Intent(ClosetActivity.this, PantsActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_skirts) {
            /*// Check for SD Card
            if (!Environment.getExternalStorageState().equals(
                    Environment.MEDIA_MOUNTED)) {
                Toast.makeText(this, "Error! No SDCARD Found!", Toast.LENGTH_LONG)
                        .show();
            } else {
                // Locate the image folder in your SD Card
                file = new File(Environment.getExternalStorageDirectory()
                        + File.separator + "Skirts");
                // Create a new folder if no folder named SDImageTutorial exist
                file.mkdirs();
            }

            if (file.isDirectory()) {
                listFile = file.listFiles();
                // Create a String array for FilePathStrings
                FilePathStrings = new String[listFile.length];
                // Create a String array for FileNameStrings
                FileNameStrings = new String[listFile.length];

                for (int i = 0; i < listFile.length; i++) {
                    // Get the path of the image file
                    FilePathStrings[i] = listFile[i].getAbsolutePath();
                    // Get the name image file
                    FileNameStrings[i] = listFile[i].getName();
                }
            }

            // Locate the GridView in gridview_main.xml
            grid = (GridView) findViewById(R.id.gridView);
            // Pass String arrays to LazyAdapter Class
            adapter = new GridViewAdapter(this, FilePathStrings, FileNameStrings);
            // Set the LazyAdapter to the GridView
            grid.setAdapter(adapter);

            // Capture gridview item click
            grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {

                    Intent i = new Intent(ClosetActivity.this, ViewImage.class);
                    // Pass String arrays FilePathStrings
                    i.putExtra("filepath", FilePathStrings);
                    // Pass String arrays FileNameStrings
                    i.putExtra("filename", FileNameStrings);
                    // Pass click position
                    i.putExtra("position", position);
                    startActivity(i);
                }

            });*/

            Intent intent = new Intent(ClosetActivity.this, SkirtsActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_dress) {

            /*// Check for SD Card
            if (!Environment.getExternalStorageState().equals(
                    Environment.MEDIA_MOUNTED)) {
                Toast.makeText(this, "Error! No SDCARD Found!", Toast.LENGTH_LONG)
                        .show();
            } else {
                // Locate the image folder in your SD Card
                file = new File(Environment.getExternalStorageDirectory()
                        + File.separator + "Dress");
                // Create a new folder if no folder named SDImageTutorial exist
                file.mkdirs();
            }

            if (file.isDirectory()) {
                listFile = file.listFiles();
                // Create a String array for FilePathStrings
                FilePathStrings = new String[listFile.length];
                // Create a String array for FileNameStrings
                FileNameStrings = new String[listFile.length];

                for (int i = 0; i < listFile.length; i++) {
                    // Get the path of the image file
                    FilePathStrings[i] = listFile[i].getAbsolutePath();
                    // Get the name image file
                    FileNameStrings[i] = listFile[i].getName();
                }
            }

            // Locate the GridView in gridview_main.xml
            grid = (GridView) findViewById(R.id.gridView);
            // Pass String arrays to LazyAdapter Class
            adapter = new GridViewAdapter(this, FilePathStrings, FileNameStrings);
            // Set the LazyAdapter to the GridView
            grid.setAdapter(adapter);

            // Capture gridview item click
            grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {

                    Intent i = new Intent(ClosetActivity.this, ViewImage.class);
                    // Pass String arrays FilePathStrings
                    i.putExtra("filepath", FilePathStrings);
                    // Pass String arrays FileNameStrings
                    i.putExtra("filename", FileNameStrings);
                    // Pass click position
                    i.putExtra("position", position);
                    startActivity(i);
                }

            });
*/
            Intent intent = new Intent(ClosetActivity.this, DressActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_shoes) {
            /*// Check for SD Card
            if (!Environment.getExternalStorageState().equals(
                    Environment.MEDIA_MOUNTED)) {
                Toast.makeText(this, "Error! No SDCARD Found!", Toast.LENGTH_LONG)
                        .show();
            } else {
                // Locate the image folder in your SD Card
                file = new File(Environment.getExternalStorageDirectory()
                        + File.separator + "Shoes");
                // Create a new folder if no folder named SDImageTutorial exist
                file.mkdirs();
            }

            if (file.isDirectory()) {
                listFile = file.listFiles();
                // Create a String array for FilePathStrings
                FilePathStrings = new String[listFile.length];
                // Create a String array for FileNameStrings
                FileNameStrings = new String[listFile.length];

                for (int i = 0; i < listFile.length; i++) {
                    // Get the path of the image file
                    FilePathStrings[i] = listFile[i].getAbsolutePath();
                    // Get the name image file
                    FileNameStrings[i] = listFile[i].getName();
                }
            }

            // Locate the GridView in gridview_main.xml
            grid = (GridView) findViewById(R.id.gridView);
            // Pass String arrays to LazyAdapter Class
            adapter = new GridViewAdapter(this, FilePathStrings, FileNameStrings);
            // Set the LazyAdapter to the GridView
            grid.setAdapter(adapter);

            // Capture gridview item click
            grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {

                    Intent i = new Intent(ClosetActivity.this, ViewImage.class);
                    // Pass String arrays FilePathStrings
                    i.putExtra("filepath", FilePathStrings);
                    // Pass String arrays FileNameStrings
                    i.putExtra("filename", FileNameStrings);
                    // Pass click position
                    i.putExtra("position", position);
                    startActivity(i);
                }

            });*/

            Intent intent = new Intent(ClosetActivity.this, ShoesActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_cessories) {
            /*// Check for SD Card
            if (!Environment.getExternalStorageState().equals(
                    Environment.MEDIA_MOUNTED)) {
                Toast.makeText(this, "Error! No SDCARD Found!", Toast.LENGTH_LONG)
                        .show();
            } else {
                // Locate the image folder in your SD Card
                file = new File(Environment.getExternalStorageDirectory()
                        + File.separator + "Accessories");
                // Create a new folder if no folder named SDImageTutorial exist
                file.mkdirs();
            }

            if (file.isDirectory()) {
                listFile = file.listFiles();
                // Create a String array for FilePathStrings
                FilePathStrings = new String[listFile.length];
                // Create a String array for FileNameStrings
                FileNameStrings = new String[listFile.length];

                for (int i = 0; i < listFile.length; i++) {
                    // Get the path of the image file
                    FilePathStrings[i] = listFile[i].getAbsolutePath();
                    // Get the name image file
                    FileNameStrings[i] = listFile[i].getName();
                }
            }

            // Locate the GridView in gridview_main.xml
            grid = (GridView) findViewById(R.id.gridView);
            // Pass String arrays to LazyAdapter Class
            adapter = new GridViewAdapter(this, FilePathStrings, FileNameStrings);
            // Set the LazyAdapter to the GridView
            grid.setAdapter(adapter);

            // Capture gridview item click
            grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {

                    Intent i = new Intent(ClosetActivity.this, ViewImage.class);
                    // Pass String arrays FilePathStrings
                    i.putExtra("filepath", FilePathStrings);
                    // Pass String arrays FileNameStrings
                    i.putExtra("filename", FileNameStrings);
                    // Pass click position
                    i.putExtra("position", position);
                    startActivity(i);
                }

            });*/

            Intent intent = new Intent(ClosetActivity.this, AccessoriesActivity.class);
            startActivity(intent);

        }

        else if(id == R.id.nav_share){
            Toast.makeText(ClosetActivity.this, "Your Message", Toast.LENGTH_LONG).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;


    }
}
