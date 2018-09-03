package com.jinhyeokfang.appjam.Activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jinhyeokfang.appjam.Adapter.MainViewPagerAdapter;
import com.jinhyeokfang.appjam.R;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MainViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        viewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        tabLayout.setupWithViewPager(viewPager);

        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        for (int i=0; i<4; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.nav_tab, null);
            TextView labelText = view.findViewById(R.id.nav_label);
            ImageView tabIcon = view.findViewById(R.id.nav_icon);
            if (i == 0) {
                labelText.setText("메인화면");
                tabIcon.setImageDrawable(getResources().getDrawable(R.drawable.bitmap));
            } else if (i == 1) {
                labelText.setText("일정수정");
                tabIcon.setImageDrawable(getResources().getDrawable(R.drawable.time));
            } else if (i == 2) {
                labelText.setText("일정확인");
                tabIcon.setImageDrawable(getResources().getDrawable(R.drawable.filled));
            } else {
                labelText.setText("일문일답");
                tabIcon.setImageDrawable(getResources().getDrawable(R.drawable.rounded));
            }

            tabLayout.getTabAt(i).setCustomView(view);
        }
    }
}
