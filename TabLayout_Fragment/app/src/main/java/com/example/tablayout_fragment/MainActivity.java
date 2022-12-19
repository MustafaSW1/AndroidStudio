package com.example.tablayout_fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    //ziehen Sie die UI nach links

    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.main_tabLayout);
        viewPager = findViewById(R.id.main_pager);

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        adapter.addTab(new MyTab("Food",CategoryFragment.newInstance(1,"Food")));
        adapter.addTab(new MyTab("Drinks",CategoryFragment.newInstance(2,"Drinks")));
        adapter.addTab(new MyTab("Deserts",CategoryFragment.newInstance(3,"Deserts")));
        adapter.addTab(new MyTab("Other",CategoryFragment.newInstance(4,"Other")));

        viewPager.setAdapter(adapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}