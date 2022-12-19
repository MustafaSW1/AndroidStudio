package com.mustafa.imagedetails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView androidImage , javaImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidImage = findViewById(R.id.androidImage);
        javaImage = findViewById(R.id.javaImage);

        androidImage.setOnClickListener(this);
        javaImage.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.androidImage:
                //Toast.makeText(getApplicationContext(),"you clicked on android Image",Toast.LENGTH_LONG).show();
                Intent intentAndroid = new Intent(MainActivity.this,InfoActivity.class);
                intentAndroid.putExtra("Name","Android OS");
                intentAndroid.putExtra("myKey","Android");
                intentAndroid.putExtra("details","Android OS Android OS  vAndroid OS Android OS " +
                        "Android OS Android OS Android OS Android OS Android OS  ");
                startActivity(intentAndroid);
            break;

            case R.id.javaImage:
                //Toast.makeText(getApplicationContext(),"you clicked on java Icon",Toast.LENGTH_LONG).show();

            Intent intentJava = new Intent(MainActivity.this,InfoActivity.class);
                intentJava.putExtra("Name","java programming");
                intentJava.putExtra("myKey","java");
                intentJava.putExtra("details","intentJava intentJava intentJava intentJava intentJava" +
                        "intentJava intentJava intentJava  intentJava intentJava intentJava ");
            startActivity(intentJava);
        }
    }
}