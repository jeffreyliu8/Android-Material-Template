package com.vimo.trainer.Banner;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
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

    public static final String ARG_NAME = "banner_name";
    public static final String ARG_IMAGE = "banner_image";

    public PageFragment() {
        // Required empty public constructor
    }

    public static PageFragment newInstance(String param1, int param2) {
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, param1);
        args.putInt(ARG_IMAGE, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTitle = getArguments().getString(ARG_NAME);
            mDrawable = getArguments().getInt(ARG_IMAGE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_page, container, false);

        TextView title = (TextView) v.findViewById(R.id.title);
        title.setText(mTitle);

        ImageView backgroundImage = (ImageView) v.findViewById(R.id.image);
        backgroundImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), mDrawable, getActivity().getTheme()));

        return v;
    }
}