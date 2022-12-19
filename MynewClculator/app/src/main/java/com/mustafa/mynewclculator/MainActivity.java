package com.mustafa.mynewclculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonSum , buttonMulit;
    private TextView textViewresult;
    private EditText number1 ,number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        buttonSum = findViewById(R.id.buttonSum);
        buttonMulit = findViewById(R.id.buttonMulti);
        textViewresult = findViewById(R.id.result);

        buttonSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mynumber1 = number1.getText().toString();
                String mynumber2 = number2.getText().toString();
                if (mynumber1.isEmpty()){
                    Toast.makeText(getApplicationContext(),"please put Value",Toast.LENGTH_LONG).show();

                }else if (mynumber2.isEmpty()){
                    Toast.makeText(getApplicationContext(),"please put Value",Toast.LENGTH_LONG).show();
                }
                else {
                    Double input1 = Double.parseDouble(mynumber1);
                    Double input2 = Double.parseDouble(mynumber2);
                    sumvalues(input1,input2).toString();
                    String finalvalue = String.valueOf(sumvalues(input1,input2));
                    textViewresult.setText("Result :  "+finalvalue);
                }
            }
        });
        buttonMulit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mynumber1 = number1.getText().toString();
                String mynumber2 = number2.getText().toString();
                if (mynumber1.isEmpty()){
                    Toast.makeText(getApplicationContext(),"please put Value",Toast.LENGTH_SHORT).show();

                }else if (mynumber2.isEmpty()){
                    Toast.makeText(getApplicationContext(),"please put Value",Toast.LENGTH_SHORT).show();
                }
                else {
                    Double input1 = Double.parseDouble(mynumber1);
                    Double input2 = Double.parseDouble(mynumber2);
                    multivalues(input1,input2);
                    String finalvalue = String.valueOf(multivalues(input1,input2));
                    textViewresult.setText("Result :"+finalvalue);
                }
            }
        });

    }

    public Double sumvalues(Double number1, Double number2){

        Double result = number1 + number2;
        return result;
    }

    public Double multivalues(Double number1, Double number2){
        Double result = number1 * number2;
        return  result;
    }
}