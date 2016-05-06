package com.example.sao.modclothesproject;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

public class InsertsMeasurementsActivity extends AppCompatActivity {
    EditText edtBust;
    EditText edtWaist;
    EditText edtHips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserts_measurements);

        edtBust = (EditText) findViewById(R.id.edtBust);
        edtWaist = (EditText) findViewById(R.id.edtWaist);
        edtHips = (EditText) findViewById(R.id.edtHips);

        /*Button button = (Button) findViewById(R.id.btnSubmit);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
               int a = Integer.parseInt(edtBust.getText().toString());

                int waist = Integer.parseInt(edtWaist.getText().toString());
                int hips = Integer.parseInt(edtHips.getText().toString());
                *//*if(a>40) {
                    Intent intent = new Intent(InsertsMeasurementsActivity.this, MaincActivity.class);
                    startActivity(intent);
                }
                else if(a>37){
                    Intent intent = new Intent(InsertsMeasurementsActivity.this, MActivity.class);
                    startActivity(intent);
                }
                else if(a>34){
                    Intent intent = new Intent(InsertsMeasurementsActivity.this,LActivity.class);
                    startActivity(intent);
                }
                else if((a>31)){
                    Intent intent = new Intent(InsertsMeasurementsActivity.this, XLActivity.class);
                    startActivity(intent);
                }*//*
                Intent intent = new Intent(InsertsMeasurementsActivity.this, MaincActivity.class);
                startActivity(intent);*/
/*
        Intent intent = new Intent(InsertsMeasurementsActivity.this, MaincActivity.class);
        startActivity(intent);*/


Button button = (Button)findViewById(R.id.btnSubmit);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(InsertsMeasurementsActivity.this, MaincActivity.class);
                startActivity(intent);
            }
        });
        Button button1 = (Button) findViewById(R.id.btnSkip);
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(InsertsMeasurementsActivity.this, CollectionActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.collections, menu);
        return true;
    }

}
