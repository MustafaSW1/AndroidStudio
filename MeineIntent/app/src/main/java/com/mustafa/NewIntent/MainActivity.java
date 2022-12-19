package com.mustafa.NewIntent;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mustafa.broadcast.R;

public class MainActivity extends AppCompatActivity {

    TextView textView1;
    EditText editText1,editText2;
    Button buttonsend;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView1 = findViewById(R.id.textView);
        editText1 = findViewById(R.id.editTextText1);
        editText2 = findViewById(R.id.editTextText2);
        buttonsend = findViewById(R.id.buttonsend);


        buttonsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText1.getText().toString().equals("") || editText2.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this,"please put numbers",Toast.LENGTH_LONG).show();
                }else {
                    int number1 = Integer.parseInt(editText1.getText().toString());
                    int number2 = Integer.parseInt(editText2.getText().toString());

                     intent = new Intent(MainActivity.this,MainActivity2.class);
                    intent.putExtra("number1",number1);
                    intent.putExtra("number2",number2);
                    intent.putExtra("bgjkgiufg",true);
                    startActivityForResult(intent,1);

                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != 0) {
            if (resultCode == RESULT_OK) {
                    int result = data.getIntExtra("Result", 0);
                    textView1.setText("" + result);
            }
            if (resultCode == RESULT_CANCELED) {
                textView1.setText("Nothing selected");
            }
        }
    }
}