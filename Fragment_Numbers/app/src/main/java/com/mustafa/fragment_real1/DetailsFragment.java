package com.mustafa.fragment_real1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;


import android.app.Fragment;

public class DetailsFragment extends Fragment {

    public static final String INDEX = "index";

    public static DetailsFragment newInstance(int index){

        DetailsFragment f = new DetailsFragment();
        Bundle args = new Bundle();
        args.putInt(INDEX,index);
        f.setArguments(args);

        return f;
    }

    public int getIndex(){
        return getArguments().getInt(INDEX,0);
    }

    @SuppressLint("StringFormatInvalid")
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        ScrollView scroller = null;
        if (container != null){
            scroller = new ScrollView(getActivity());
            TextView text = new TextView(getActivity());
            scroller.addView(text);

            text.setText(getString(R.string.template,
                    1 + getIndex()));

            //text.setText(getResources(R.string.template+1getIndex()));
        }
        return scroller;
    }
}
