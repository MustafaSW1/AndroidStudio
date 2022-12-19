package com.example.recycler_cardview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class InfoActivity extends AppCompatActivity {
    TextView name,age,description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        name = findViewById(R.id.name);
        age = findViewById(R.id.age_id);
        description = findViewById(R.id.info);

        Intent intent = getIntent();
        name.setText(intent.getStringExtra("Name"));
        age.setText(intent.getStringExtra("Age"));
        description.setText(intent.getStringExtra("Des"));
    }
}