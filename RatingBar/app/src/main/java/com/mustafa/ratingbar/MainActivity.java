package com.mustafa.ratingbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonshow;
    TextView textViewResult;
    RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       textViewResult = findViewById(R.id.mytextview);
       ratingBar = findViewById(R.id.ratingBar);
       buttonshow = findViewById(R.id.buttonshow);


       buttonshow.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String totalValue = ratingBar.getNumStars()+"";
               String ratting = ratingBar.getRating()+"";
               textViewResult.setText(ratting);
               Toast.makeText(getApplicationContext(),
                       "your result "+ratting,Toast.LENGTH_LONG).show();
           }
       });
    }
}