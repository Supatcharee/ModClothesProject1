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
    EditText etFName;
    EditText etLName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserts_measurements);
        etFName = (EditText) findViewById(R.id.edtBust);
        etLName = (EditText) findViewById(R.id.edtWaist);

        Button button = (Button) findViewById(R.id.btnSubmit);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                int b = Integer.parseInt(etLName.getText().toString());
                if(b==34){
                    Intent intent = new Intent(InsertsMeasurementsActivity.this, CollectionActivity.class);
                    startActivity(intent);
                }
                else if(b==36){
                    Intent intent = new Intent(InsertsMeasurementsActivity.this, MActivity.class);
                    startActivity(intent);
                }
                else if(b==38){
                    Intent intent = new Intent(InsertsMeasurementsActivity.this,LActivity.class);
                    startActivity(intent);
                }
                else if(b>=40){
                    Intent intent = new Intent(InsertsMeasurementsActivity.this, XLActivity.class);
                    startActivity(intent);
                }


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
