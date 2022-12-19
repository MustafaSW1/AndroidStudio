package com.mustafa.fragmentme2;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;

public class FragmentA extends Fragment implements View.OnClickListener {

    Button button,minus;
    conection conn;
    int count = 0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_a_layout,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        conn = (conection)getActivity();
        button = (getActivity().findViewById(R.id.button));
        button.setOnClickListener(this);

        minus = (Button)getActivity().findViewById(R.id.button2);
        minus.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        count++;
        conn.con("Hi this is message:"+count);

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                if (count <= 0){
                    count = 0;

                }
                conn.con("Hi this is message:"+count);

            }
        });

    }
}
