package com.vimo.trainer;


import android.content.Context;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vimo.trainer.Banner.BannerPageAdapter;
import com.vimo.trainer.WorkoutDetail.ViewModel;
import com.vimo.trainer.WorkoutDetail.WorkoutDetailActivity;

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
        private TextView mCategoryTitle;

        public GroupViewHolder(View itemView) {
            super(itemView);
            mCategoryTitle = (TextView) itemView.findViewById(R.id.category_title);
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
                final GroupViewHolder groupViewHolder = (GroupViewHolder) viewHolder;
                final int image0 = mCategories.get(position - 1).getList(0).getImageId();
                final String exerciseName0 = mCategories.get(position - 1).getList(0).getName();
                final String description0 = mCategories.get(position - 1).getList(0).getDescription();

                groupViewHolder.mCard0.setTitle(exerciseName0);
                groupViewHolder.mCard0.setDescription(description0);
                groupViewHolder.mCard0.setImage(ResourcesCompat.getDrawable(mContext.getResources(), image0, mContext.getTheme()));
                groupViewHolder.mCard0.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ViewModel viewModel = new ViewModel(exerciseName0, image0);
                        WorkoutDetailActivity.navigate((AppCompatActivity) mContext, v.findViewById(R.id.image), viewModel);
                    }
                });

                final int image1 = mCategories.get(position - 1).getList(1).getImageId();
                final String exerciseName1 = mCategories.get(position - 1).getList(1).getName();
                final String description1 = mCategories.get(position - 1).getList(1).getDescription();

                groupViewHolder.mCard1.setTitle(exerciseName1);
                groupViewHolder.mCard1.setDescription(description1);
                groupViewHolder.mCard1.setImage(ResourcesCompat.getDrawable(mContext.getResources(), image1, mContext.getTheme()));
                groupViewHolder.mCard1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ViewModel viewModel = new ViewModel(exerciseName1, image1);
                        WorkoutDetailActivity.navigate((AppCompatActivity) mContext, v.findViewById(R.id.image), viewModel);
                    }
                });


                if (groupViewHolder.mCard2 != null) {
                    final int image2 = mCategories.get(position - 1).getList(2).getImageId();
                    final String exerciseName2 = mCategories.get(position - 1).getList(2).getName();
                    final String description2 = mCategories.get(position - 1).getList(2).getDescription();

                    groupViewHolder.mCard2.setTitle(exerciseName2);
                    groupViewHolder.mCard2.setDescription(description2);
                    groupViewHolder.mCard2.setImage(ResourcesCompat.getDrawable(mContext.getResources(), image2, mContext.getTheme()));
                    groupViewHolder.mCard2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ViewModel viewModel = new ViewModel(exerciseName2, image2);
                            WorkoutDetailActivity.navigate((AppCompatActivity) mContext, v.findViewById(R.id.image), viewModel);
                        }
                    });
                }
                if (groupViewHolder.mCard3 != null) {
                    final int image3 = mCategories.get(position - 1).getList(3).getImageId();
                    final String exerciseName3 = mCategories.get(position - 1).getList(3).getName();
                    final String description3 = mCategories.get(position - 1).getList(3).getDescription();

                    groupViewHolder.mCard3.setTitle(exerciseName3);
                    groupViewHolder.mCard3.setDescription(description3);
                    groupViewHolder.mCard3.setImage(ResourcesCompat.getDrawable(mContext.getResources(), image3, mContext.getTheme()));
                    groupViewHolder.mCard3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ViewModel viewModel = new ViewModel("456", image3);
                            WorkoutDetailActivity.navigate((AppCompatActivity) mContext, v.findViewById(R.id.image), viewModel);
                        }
                    });
                }

                groupViewHolder.mCategoryTitle.setText(mCategories.get(position - 1).getName());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mCategories.size() + 1;
    }
}