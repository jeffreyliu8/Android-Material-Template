package com.vimo.trainer.Banner;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


/**
 * Created by Jeffrey Liu on 10/26/15.
 */

public class BannerPageAdapter extends FragmentStatePagerAdapter {
    private PageFragment tab0;
    private PageFragment tab1;
    private PageFragment tab2;

    public BannerPageAdapter(FragmentManager fm) {
        super(fm);
        tab0 = new PageFragment();
        tab1 = new PageFragment();
        tab2 = new PageFragment();
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                //tab0 = new PageFragment();
                return tab0;
            case 1:
                // tab1 = new PageFragment();
                return tab1;
            case 2:
                // tab2 = new PageFragment();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    public void setTabTextImage(int position, String title, int drawable) {
        switch (position) {
            case 0:
                tab0.setTextImage(title, drawable);
            case 1:
                tab1.setTextImage(title, drawable);
            case 2:
                tab2.setTextImage(title, drawable);
        }
    }
}