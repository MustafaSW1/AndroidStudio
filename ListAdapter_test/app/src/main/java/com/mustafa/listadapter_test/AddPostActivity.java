package com.mustafa.listadapter_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPostActivity extends AppCompatActivity {

    EditText et_name, et_body, et_date, et_followers, et_following ,et_posts;
    Button btn_add;
    Button btn_backToMain;
    public static final String POST_CONSE_NAME = "post";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);


        et_name = findViewById(R.id.add_post_name);
        et_body = findViewById(R.id.add_post_body);
        et_date = findViewById(R.id.add_post_dateac);
        et_followers = findViewById(R.id.add_post_followers);
        et_following = findViewById(R.id.add_post_following);
        et_posts = findViewById(R.id.add_post_posts);
        btn_add = findViewById(R.id.add_btn_save);


        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (!TextUtils.isDigitsOnly(et_following.getText().toString())
                        && !TextUtils.isDigitsOnly(et_followers.getText().toString())
                        && !TextUtils.isDigitsOnly(et_posts.getText().toString())) {
                    Toast.makeText(getBaseContext(), "please put number", Toast.LENGTH_SHORT).show();
                } else {
                    String name = et_name.getText().toString();
                    String body = et_body.getText().toString();
                    String date = et_date.getText().toString();
                    int followers = Integer.parseInt(et_followers.getText().toString());
                    int following = Integer.parseInt(et_following.getText().toString());
                    int posts = Integer.parseInt(et_posts.getText().toString());

                Post post = new Post(name, body, date, followers, following, posts);

                Intent intent = new Intent(getBaseContext(), TestList.class);
                intent.putExtra(POST_CONSE_NAME, post);

                startActivity(intent);
                finish();
                }

            }
        });
        btn_backToMain = findViewById(R.id.btn_back_to_main);
        btn_backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}