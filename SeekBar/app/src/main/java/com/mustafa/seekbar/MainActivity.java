package com.mustafa.seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.media.ExifInterface;
import android.media.Image;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    TextView textView;
    ScrollView scrollView;
    boolean a ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBar2);
        textView = findViewById(R.id.textView5);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast.makeText(MainActivity.this, "onProgressChanged"+progress, Toast.LENGTH_SHORT).show();
                textView.setText(" ");
                textView.setText(progress+"onProgressChanged");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                textView.setText(" ");
                textView.append("onStartTrackingTouch");

            }


            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textView.setText(" ");
                textView.append("onStopTrackingTouch");

            }
        });

    }
}