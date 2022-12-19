package com.mustafa.frombook;


import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends Activity {

    TextView textView;
    Calendar calendar;
    SimpleDateFormat simpleDateFormat;
    String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
        textView = findViewById(R.id.textView);
        calendar = Calendar.getInstance();
        textView.append("the day is "+calendar.get(Calendar.DAY_OF_YEAR)+" from year "+
                calendar.get(Calendar.YEAR));

        try {
            Thread.sleep(1000);
            simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            date = simpleDateFormat.format(calendar.getTime());
            textView.append("\n\n"+"the Time is "+date);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        
    }
}