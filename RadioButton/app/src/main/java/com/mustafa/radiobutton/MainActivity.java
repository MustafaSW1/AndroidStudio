package com.mustafa.radiobutton;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.RadioGrupeid);
        textView = findViewById(R.id.textView);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group,@IdRes int checkedId) {

                radioButton = findViewById(checkedId);
                switch (radioButton.getId()) {
                    case R.id.pizzaid: {
                        textView.setVisibility(View.VISIBLE);
                        textView.setText("Pizza");
                    }
                    break;
                    case R.id.hambergerid: {
                        textView.setVisibility(View.VISIBLE);
                        textView.setText("hamberger");
                    }
                    break;
                    case R.id.steak: {
                        textView.setVisibility(View.VISIBLE);
                        textView.setText("Steak");
                    }
                }
            }
        });
        }
        }
