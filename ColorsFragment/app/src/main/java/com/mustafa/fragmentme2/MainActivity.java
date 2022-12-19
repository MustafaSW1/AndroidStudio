package com.mustafa.fragmentme2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements conection {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    @Override
    public void con(String data) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentB b = (FragmentB) fragmentManager.findFragmentById(R.id.fragment2);
        b.modifyText(data);
    }
}