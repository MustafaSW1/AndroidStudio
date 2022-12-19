package com.mustafa.listadapter_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class TestList extends AppCompatActivity {

    Button btn_like,btn_share,btn_comment,btn_add;
    ListView lv;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_like = findViewById(R.id.custom_body_btn_likes);
        //btn_like.setBackgroundColor(Color.WHITE);
        //btn_like.setTextColor(Color.BLACK);

        btn_share = findViewById(R.id.custom_body_btn_share);
        //btn_share.setBackgroundColor(Color.WHITE);
        //btn_share.setTextColor(Color.BLACK);

        btn_comment = findViewById(R.id.custom_body_btn_comment);
        //btn_comment.setBackgroundColor(Color.WHITE);
        //btn_comment.setTextColor(Color.BLACK);

        //zum Informationen senden
        btn_add = findViewById(R.id.list_button_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),AddPostActivity.class);
                startActivity(intent);
            }
        });
        //zum Informationen impfangen

        Intent back_info = getIntent();
        back_info.getSerializableExtra(AddPostActivity.POST_CONSE_NAME);
        String s = back_info.toString();



        lv = findViewById(R.id.test_list);

        imageView = findViewById(R.id.imageView2);
//        imageView.setVisibility(View.VISIBLE);

        ArrayList<Post> posts1 = new ArrayList<>();

        //ArrayAdapter<Post> posts = new ArrayAdapter<>(this,R.layout.custom_post);


        //posts1.add(new Post("13.07.2018","Mustafa Ibraheem","Welcome to java",
        //    15,26,19));

        //posts1.add(new Post("28.10.2019","Tahsin ahmed","Welcome to C++",
        // 50,20,80));

        //posts1.add(new Post("02.05.2021","Samier muhammed","Welcome to C#",
        //30,30,30));

        PostAdapter adapter = new PostAdapter(this,R.layout.custom_post,posts1);

        Post p1 = (Post) back_info.getSerializableExtra(AddPostActivity.POST_CONSE_NAME) ;
        adapter.addItem(p1);

        lv.setAdapter(adapter);



    }
}