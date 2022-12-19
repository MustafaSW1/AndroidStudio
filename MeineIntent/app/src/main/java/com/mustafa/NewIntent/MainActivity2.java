package com.mustafa.NewIntent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.mustafa.broadcast.R;

public class MainActivity2 extends AppCompatActivity {

    TextView textView1;
    Button buttonAdd , buttonSub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView1 = findViewById(R.id.textView2);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSub = findViewById(R.id.buttonSub);

        Intent intent = getIntent();
        intent.putExtra("bgjkgiufg",true);
        int number1 = intent.getIntExtra("number1",0);
        int number2 = intent.getIntExtra("number2",0);

        textView1.setText("Numbers :" +number1+", " +number2);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = number1+number2;
                Intent intentResult = new Intent();
                intent.putExtra("Result",result);

                setResult(RESULT_OK,intentResult);
            finish();
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = number1-number2;
                Intent intentResult = new Intent();
                intent.putExtra("Result",result);
                intent.putExtra("bgjkgiufg",true);

                setResult(RESULT_OK,intentResult);
                finish();
            }
        });
    }
}