package com.jinhyeokfang.appjam.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jinhyeokfang.appjam.Fragment.CalenderFragment;
import com.jinhyeokfang.appjam.Fragment.DairyTimeLineFragment;
import com.jinhyeokfang.appjam.Fragment.QuestionFragment;
import com.jinhyeokfang.appjam.Fragment.TodayFragment;

public class MainViewPagerAdapter extends FragmentPagerAdapter {


    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0)
            return new DairyTimeLineFragment();
        else if (position == 1)
            return new TodayFragment();
        else if (position == 2)
            return new CalenderFragment();
        else
            return new QuestionFragment();
    }

    @Override
    public int getCount() {
        return 4;
    }
}
