package com.mustafa.myactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button toSecoundActivity, toThirdActivity;
    private final int REQWEST_CODE = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Toast.makeText(getApplicationContext(),"onCreate",Toast.LENGTH_SHORT).show();
        toSecoundActivity = findViewById(R.id.buttonSecond);
        toThirdActivity = findViewById(R.id.buttonThird);

        toSecoundActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("FirstName", "mustafa");
                intent.putExtra("lastName", "Ibraheem");
                intent.putExtra("welcomeMessage", "Hallo from first to second");
                intent.putExtra("age", "alt : 20");
                intent.putExtra("salary", "Gehalt : 1000.4");
                //startActivity(intent);
                startActivityForResult(intent, REQWEST_CODE);
            }
        });


        toThirdActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                intent.putExtra("FirstName", "ahmed hassan");
                intent.putExtra("lastName", "Omar");
                intent.putExtra("welcomeMessage", "Hallo from first to Third");
                intent.putExtra("age", "Alt : 26");
                intent.putExtra("salary", "Gehalt : 3000.4");

                startActivityForResult(intent,REQWEST_CODE);
            }
        });

    }

    @Override
    public void onActivityReenter(int resultCode, Intent data) {
        super.onActivityReenter(resultCode, data);
        if (resultCode == REQWEST_CODE){

                String backData = data.getStringExtra("mustafa");
                Toast.makeText(getApplicationContext(),backData,Toast.LENGTH_LONG).show();
            }
        }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != REQWEST_CODE){
            if (requestCode != RESULT_OK){
                String ReturnData = data.getStringExtra("hh");
                Toast.makeText(getApplicationContext(),ReturnData,Toast.LENGTH_LONG).show();
            }
        }
    }
}

/*
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(),"onCreate",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(),"onStop",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"onDestroy",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),"onPause",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),"onResume",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(),"onRestart",Toast.LENGTH_SHORT).show();
    }
 */

