package com.example.level_list_drawal;

import static com.example.level_list_drawal.R.drawable.lld;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.LevelListDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageButton plus;
    ImageButton minus;
    ImageView imageView;
    private LevelListDrawable levelListDrawable;
    private int x = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plus = findViewById(R.id.imageButton1);
        minus = findViewById(R.id.imageButton2);
        imageView = findViewById(R.id.imageView);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (x<6)
            x++;
            imageView.setImageLevel(x);

            }
        });
        
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(x>0)
                x--;
                imageView.setImageLevel(x);
            }
        });


    }
}