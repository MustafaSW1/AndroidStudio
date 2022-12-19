package com.example.diloge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        DalogFragment.OnPositiveClickListener,
        DalogFragment.OnNegativeClickListener,
        DalogFragment.OnNeutralClickListener {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DalogFragment fragment = DalogFragment.newInstance
                ("Description","i need configuration",R.drawable.ic_launcher_background);
                fragment.show(getSupportFragmentManager(),null);
            }
        });
    }

    @Override
    public void onPositiveClickListener() {
        Toast.makeText(getBaseContext(), "Clicked on YES", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNegativeClickListener() {
        Toast.makeText(getBaseContext(), "Clicked on NO", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNeutralClickListener() {
        Toast.makeText(getBaseContext(), "Clicked on Cancel", Toast.LENGTH_SHORT).show();
    }
}