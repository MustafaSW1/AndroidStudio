package com.mustafa.bluetooth_project;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


//Den programm funktioniert auf Reales handy
public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button on ,off;
    ImageView imageView;

    BluetoothAdapter bluetoothAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = findViewById(R.id.text_view1);
        on = findViewById(R.id.buttonOn);
        off = findViewById(R.id.buttonOFF);
        imageView = findViewById(R.id.imageView1);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!on.isPressed()){
                    textView.setTextColor(Color.RED);
                   textView.setText("Bluetooth is OFF");
                    Toast.makeText(MainActivity.this,"Turned OFF",
                                Toast.LENGTH_LONG).show();
                    bluetoothAdapter.disable();

                }else {
                    textView.setTextColor(Color.GREEN);
                    textView.setText("Bluetooth is ON");
                    Toast.makeText(MainActivity.this,"Turned ON",
                            Toast.LENGTH_LONG).show();
                    bluetoothAdapter.enable();
                    imageView.setColorFilter(Color.GREEN);
                    Intent intenton = new Intent(bluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(intenton,0);

                }
            }
        });
        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (off.isPressed()){
                    textView.setText("Bluetooth is OFF");
                    textView.setTextColor(Color.RED);
                    imageView.setColorFilter(Color.RED);
                    Toast.makeText(MainActivity.this,"Turned OFF",
                            Toast.LENGTH_LONG).show();
                    bluetoothAdapter.disable();

                }
            }
        });
    }
}