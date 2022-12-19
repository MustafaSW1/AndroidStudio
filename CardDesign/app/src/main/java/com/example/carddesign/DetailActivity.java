package com.example.carddesign;

import static com.example.carddesign.R.array.sports_images;
import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView sportsTitle = findViewById(R.id.titleDetail);
        ImageView sportsImage = findViewById(R.id.sportsImageDetail);

        // Set the text from the Intent extra.
        //sportsTitle.setText(getIntent().getStringExtra("title"));

        // Load the image using the Glide library and the Intent extra.

        String mTitle = sportsTitle.getText().toString();
        int mImage = sportsImage.getImageAlpha();

        Intent intent = getIntent();
        mTitle = intent.getStringExtra("title");
        mImage = intent.getIntExtra("image_resource",0);


        sportsTitle.setText(mTitle);
        sportsImage.setImageResource(mImage);

        //Glide.with(getBaseContext()).load(image).into(sportsImage);
        //Glide.with(this).load(getIntent().getIntExtra("image_resource",0))
        //    .into(sportsImage);
    }
}