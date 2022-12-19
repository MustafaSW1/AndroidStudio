package com.mustafa.permission2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int RQ_CODE_PERMISSITON = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);
        
    }

    @Override
    protected void onStart() {
        super.onStart();


        if (checkSelfPermission(Manifest.permission.READ_CALL_LOG)!= PackageManager.PERMISSION_GRANTED){
            textView.setText("?????????????");
           if (shouldShowRequestPermissionRationale(Manifest.permission.READ_CALL_LOG)){
               textView.setText("we haven't got the permission befor xxxx");
           }else{
               requestPermissions(new String[]{Manifest.permission.READ_CALL_LOG},RQ_CODE_PERMISSITON);
           }
        }else {
            textView.setText("we have got the permission befor");
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


        if (requestCode == RQ_CODE_PERMISSITON){
            textView.setText("no permission");
            if (grantResults.length >0 && grantResults[0]==PackageManager.PERMISSION_GRANTED ) {

                textView.setText("permission1 thank you");

            }
        }
    }
}