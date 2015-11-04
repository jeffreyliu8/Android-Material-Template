package com.vimo.trainer.Banner;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vimo.trainer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragment extends Fragment {

    private String mTitle;
    private int mDrawable;


    public PageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_page, container, false);

        TextView title = (TextView) v.findViewById(R.id.title);
        title.setText(mTitle);

        ImageView backgroundImage = (ImageView) v.findViewById(R.id.image);
        Log.d("jeff", "drawable is" + mDrawable);
        if (mDrawable != 0)
            backgroundImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), mDrawable, getActivity().getTheme()));

        return v;
    }

    public void setTextImage(String title, int drawable) {
        this.mTitle = title;
        this.mDrawable = drawable;
    }

    // for rotation
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null) {
            //Restore the fragment's state here
            savedInstanceState.getInt("draw");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //Save the fragment's state here
        outState.putInt("draw", mDrawable);
    }
}