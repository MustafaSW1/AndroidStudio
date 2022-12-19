package com.mustafa.adapter1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.usage.StorageStatsManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    EditText et_name;
    Button btn_add;
    MyAdapter myAdapter;
    int currentposition = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.test_list);
        et_name = findViewById(R.id.list_edittext);
        btn_add = findViewById(R.id.btn_list);



        ArrayList<String> names = new ArrayList<>();


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1
        ,names);

        myAdapter = new MyAdapter(this,names);
        lv.setAdapter(myAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //int p = position+1;
                //String f = myAdapter.data.get(position);
                et_name.setText(names.get(position));
               // Toast.makeText(MainActivity.this, "item "+p+" "+f, Toast.LENGTH_SHORT).show();
                currentposition = position;
                btn_add.setText("Edit");
            }
        });


       btn_add.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               if (currentposition >= 0){
                   myAdapter.SetItem(currentposition,et_name.getText().toString());
                   btn_add.setText("Add");
                   currentposition = -1;

               }else {
                   myAdapter.AddItem(et_name.getText().toString());
                   et_name.setText(" ");
               }
               myAdapter.notifyDataSetChanged();
           }
       });

    }
}