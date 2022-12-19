package com.mustafa.alertdailog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;
    AlertDialog.Builder alertDailog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               alertDailog = new AlertDialog.Builder(MainActivity.this);
               alertDailog.setTitle(getResources().getString(R.string.hollw));
               alertDailog.setMessage(getResources().getString(R.string.attention));
               alertDailog.setCancelable(false);
               alertDailog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       MainActivity.this.finish();
                   }
               });

               alertDailog.setNegativeButton("no", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       dialog.cancel();
                   }
               });

               AlertDialog dialog = alertDailog.show();
           }
       });
    }
}