package com.vimo.trainer;


import android.content.Context;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vimo.trainer.Banner.BannerPageAdapter;

import java.util.List;

/**
 * Created by jeffliu on 11/3/15.
 */
public class WorkoutRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<WorkoutCategory> mCategories;


    public WorkoutRecyclerAdapter(List<WorkoutCategory> categories, Context c) {
        this.mContext = c;
        this.mCategories = categories;

    }

    private class GroupViewHolder extends RecyclerView.ViewHolder {
        private WorkoutCardView mCard0;
        private WorkoutCardView mCard1;
        private WorkoutCardView mCard2;
        private WorkoutCardView mCard3;


        public GroupViewHolder(View itemView) {
            super(itemView);
            mCard0 = (WorkoutCardView) itemView.findViewById(R.id.card0);
            mCard1 = (WorkoutCardView) itemView.findViewById(R.id.card1);
            mCard2 = (WorkoutCardView) itemView.findViewById(R.id.card2);
            mCard3 = (WorkoutCardView) itemView.findViewById(R.id.card3);
        }
    }

    private class ImageViewHolder extends RecyclerView.ViewHolder {
        private ViewPager mViewPager;
        private BannerPageAdapter mPageAdapter;

        public ImageViewHolder(View itemView) {
            super(itemView);
            mViewPager = (android.support.v4.view.ViewPager) itemView.findViewById(R.id.pager);
            mPageAdapter = new BannerPageAdapter(((AppCompatActivity) mContext).getSupportFragmentManager());
            mViewPager.setAdapter(mPageAdapter);
            //mViewPager.setOffscreenPageLimit(3);
        }
    }

    private static final int TYPE_IMAGE = 1;
    private static final int TYPE_GROUP = 2;

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? TYPE_IMAGE : TYPE_GROUP;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_IMAGE: {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.workout_viewholder_top, parent, false);
                return new ImageViewHolder(v);
            }
            default:
            case TYPE_GROUP: {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.workout_viewholder_viewpage, parent, false);
                return new GroupViewHolder(v);
            }
        }
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        switch (viewHolder.getItemViewType()) {
            case TYPE_IMAGE:
                ImageViewHolder imageViewHolder = (ImageViewHolder) viewHolder;
                imageViewHolder.mPageAdapter.setTabTextImage(0, "page 1", android.R.drawable.ic_delete);
                imageViewHolder.mPageAdapter.setTabTextImage(1, "page 2", android.R.drawable.ic_dialog_alert);
                imageViewHolder.mPageAdapter.setTabTextImage(2, "page 3", android.R.drawable.ic_dialog_info);

                break;
            case TYPE_GROUP:
                GroupViewHolder groupViewHolder = (GroupViewHolder) viewHolder;
                groupViewHolder.mCard0.setTitle("group 0");
                groupViewHolder.mCard0.setDescription("de 0");
                groupViewHolder.mCard0.setImage(ResourcesCompat.getDrawable(mContext.getResources(), android.R.drawable.alert_dark_frame, mContext.getTheme()));

                groupViewHolder.mCard1.setTitle("group 1");
                groupViewHolder.mCard1.setDescription("de 1");
                groupViewHolder.mCard1.setImage(ResourcesCompat.getDrawable(mContext.getResources(), android.R.drawable.checkbox_off_background, mContext.getTheme()));


                if (groupViewHolder.mCard2 != null) {
                    groupViewHolder.mCard2.setTitle("group 2");
                    groupViewHolder.mCard2.setDescription("de 2");
                    groupViewHolder.mCard2.setImage(ResourcesCompat.getDrawable(mContext.getResources(), android.R.drawable.bottom_bar, mContext.getTheme()));
                }
                if (groupViewHolder.mCard3 != null) {
                    groupViewHolder.mCard3.setTitle("group 3");
                    groupViewHolder.mCard3.setDescription("de 3");
                    groupViewHolder.mCard3.setImage(ResourcesCompat.getDrawable(mContext.getResources(), android.R.drawable.ic_menu_sort_alphabetically, mContext.getTheme()));
                }
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mCategories.size() + 1;
    }
}