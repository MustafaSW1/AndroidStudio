package com.example.ui_testing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //zum starten Android -> com.example.ui_testing -> MainActivityTest rechte maus and starten

    EditText userName,password;
    Button send;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        userName = findViewById(R.id.user_name);
        password = findViewById(R.id.pass_word);
        send = findViewById(R.id.btn_send);

        String user = userName.getText().toString();
        String pass = password.getText().toString();





            send.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                        count++;
                        userName.setText(user);
                        password.setText(pass);

                        if (count >= 5)
                            Toast.makeText(getBaseContext(), "to many tries", Toast.LENGTH_SHORT).show();
                }
            });

    }
}