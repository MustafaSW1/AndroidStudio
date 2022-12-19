package com.mustafa.myactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Bundle extras = getIntent().getExtras();
        textView = findViewById(R.id.textView4);
        button = findViewById(R.id.buttonBack2);

        String fromFirstView = extras.getString("FirstName");
        String fromFirstView2 = extras.getString("lastName");
        String fromFirstView3 = extras.getString("welcomeMessage");
        String fromFirstView4 = extras.getString("age");
        String fromFirstView5 = extras.getString("salary");
        textView.setText(fromFirstView+"\n"+fromFirstView2+"\n"+fromFirstView3+
                "\n"+fromFirstView4+"\n"+fromFirstView5);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backinfo = getIntent();
                backinfo.putExtra("mustafa","back info from third to main");
                setResult(RESULT_OK,backinfo);
                finish();
            }
        });

    }
}