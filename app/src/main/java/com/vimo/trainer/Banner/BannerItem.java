package com.vimo.trainer.Banner;

/**
 * Created by Jeffrey Liu on 11/6/15.
 */
public class BannerItem {
    private int mBannerImage;
    private String mBannerName;

    public BannerItem(String name, int image) {
        mBannerName = name;
        mBannerImage = image;
    }

    public String getmBannerName() {
        return mBannerName;
    }

    public int getmBannerImage() {
        return mBannerImage;
    }
}
