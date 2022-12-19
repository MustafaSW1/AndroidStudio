package com.mustafa.fragment_real1;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;


public class DetailsActivity extends Activity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            finish();
            return;
        }
        if (savedInstanceState == null){
            DetailsFragment details = new DetailsFragment();
            details.setArguments(getIntent().getExtras());
            //getSupportFragmentManager().beginTransaction().add(R.id.content, (details)).commit();
            getFragmentManager().beginTransaction().add(android.R.id.content,details).commit();
        }
    }
}
