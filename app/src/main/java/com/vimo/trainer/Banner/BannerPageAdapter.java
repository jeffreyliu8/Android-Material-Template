package com.vimo.trainer.Banner;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeffrey Liu on 10/26/15.
 */

public class BannerPageAdapter extends FragmentStatePagerAdapter {
    private List<BannerItem> mBanners;
    private List<PageFragment> pageFragments;

    public BannerPageAdapter(List<BannerItem> list, FragmentManager fm) {
        super(fm);

        mBanners = list;
        pageFragments = new ArrayList<PageFragment>(list.size());

        for (int i = 0; i < list.size(); i++) {
            pageFragments.add(i, PageFragment.newInstance(mBanners.get(i).getmBannerName(), mBanners.get(i).getmBannerImage()));
        }
    }

    @Override
    public Fragment getItem(int position) {
        return pageFragments.get(position);
    }

    @Override
    public int getCount() {
        return mBanners.size();
    }
}