package com.example.roomwordsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

public class NewWordActivity extends AppCompatActivity {

    private static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";
    private EditText mEditWordView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);

        mEditWordView = findViewById(R.id.edit_word);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(view -> {
            Intent backIntent = new Intent();

            if (TextUtils.isEmpty(mEditWordView.getText())){
                setResult(RESULT_CANCELED,backIntent);
            }else {
                    String word = mEditWordView.getText().toString();
                    backIntent.putExtra(EXTRA_REPLY, word);
                    setResult(RESULT_OK, backIntent);
            }

            finish();
        });

    }
}