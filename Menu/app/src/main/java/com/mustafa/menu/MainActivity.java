package com.mustafa.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv ;
    TextView textView;
    int num_notification;
    View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textview);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);

        MenuItem item = menu.findItem(R.id.menu_notification);
         v = item.getActionView();
        textView = v.findViewById(R.id.custom_notification_tv);
        textView.setText("10");

        if (textView == null){
            textView.setVisibility(View.INVISIBLE);
            return true;
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        
        //menü zeigen mit Toast
        Toast.makeText(this, item.toString(), Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}















/*
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_notification:
                Toast.makeText(this, "notification", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu_settings:
                Toast.makeText(this, "setting", Toast.LENGTH_SHORT).show();
                break;

            default:
                Toast.makeText(this, "no any thing", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
     */


//______________________________________________________

//menü zeigen mit switch case
        /*
        switch (item.getItemId()){
            case R.id.menu_notification:
                Toast.makeText(this, "notification", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu_settings:
                Toast.makeText(this, "setting", Toast.LENGTH_SHORT).show();
                break;

            default:
                Toast.makeText(this, "no any thing", Toast.LENGTH_SHORT).show();
        }
         */







