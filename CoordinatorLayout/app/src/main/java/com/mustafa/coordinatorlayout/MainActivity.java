package com.mustafa.coordinatorlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton btn;
        btn = findViewById(R.id.btn_snack);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar s = Snackbar.make(btn,"click to button", Snackbar.LENGTH_SHORT);
                s.setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                s.show();
            }
        });
    }
}