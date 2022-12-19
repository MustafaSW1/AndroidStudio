package com.mustafa.snackbar1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn_snack);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Snackbar.make(button,R.string.app_name,Snackbar.LENGTH_SHORT).show();
                Snackbar s = Snackbar.make(button,"hallo",Snackbar.LENGTH_SHORT);
                s.setAction("Ok", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "bay bay", Toast.LENGTH_SHORT).show();
                    }
                });
                s.show();
            }
        });

    }
}