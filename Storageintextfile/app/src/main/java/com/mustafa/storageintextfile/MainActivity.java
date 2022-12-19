package com.mustafa.storageintextfile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    // 1-schreiben Sie etwas im textfeld
    // 2-verlassen und zerstören Sie den programm
    // 3-klicken Sie wieder auf dem programm ,finden Sie was Sie im ersten schritt gesrieben haben

    TextView textView;
    EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        textView=  findViewById(R.id.textView);
        editText = findViewById(R.id.editTextTextPersonName);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editText.getText().toString().isEmpty()){
                    String message = editText.getText().toString();
                    writeToText(message);
                }
            }
        });
        try {
            if (readData()!=null){
                textView.setText(readData());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeToText(String filetext){

        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput
                    ("myfile.txt",Context.MODE_PRIVATE));
            outputStreamWriter.write(filetext);
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readData() throws IOException {
        String mystored = "";
        InputStream inputStream = openFileInput("myfile.txt");
        if (inputStream != null){
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String tempData = "";
            StringBuilder stringBuilder = new StringBuilder();
            while ((tempData = bufferedReader.readLine())!= null){
                stringBuilder.append(tempData);
            }
            inputStream.close();

            mystored = stringBuilder.toString();
        }
        return mystored;

    }
}