package com.vimo.trainer;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vimo.trainer.Banner.BannerItem;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link WorkoutFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link WorkoutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WorkoutFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private static final String KEY_LAYOUT_MANAGER = "layoutManager";
    private static final String KEY_VIEW_PAGER_NUMBER = "page number";

    private WorkoutRecyclerAdapter adapter;
    private RecyclerView mRecyclerView;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WorkoutFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WorkoutFragment newInstance(String param1, String param2) {
        WorkoutFragment fragment = new WorkoutFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public WorkoutFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_workout, container, false);
//

        WorkoutExercise a = new WorkoutExercise("a", android.R.drawable.ic_delete, "descp a");
        WorkoutExercise b = new WorkoutExercise("b", android.R.drawable.ic_menu_report_image, "descp b");
        WorkoutExercise c = new WorkoutExercise("c", android.R.drawable.ic_search_category_default, "descp c");
        WorkoutExercise d = new WorkoutExercise("d", android.R.drawable.ic_dialog_alert, "descp d");

        WorkoutExercise e = new WorkoutExercise("e", android.R.drawable.ic_delete, "descp e");
        WorkoutExercise f = new WorkoutExercise("f", android.R.drawable.ic_menu_report_image, "descp f");
        WorkoutExercise g = new WorkoutExercise("g", android.R.drawable.ic_search_category_default, "descp g");
        WorkoutExercise h = new WorkoutExercise("h", android.R.drawable.ic_dialog_alert, "descp h");


        WorkoutCategory c1 = new WorkoutCategory("first");
        WorkoutCategory c2 = new WorkoutCategory("second");
        WorkoutCategory c3 = new WorkoutCategory("third");
        c1.addExercise(a);
        c1.addExercise(b);
        c1.addExercise(c);
        c1.addExercise(d);
        c2.addExercise(e);
        c2.addExercise(f);
        c2.addExercise(g);
        c2.addExercise(h);
        c3.addExercise(a);
        c3.addExercise(b);
        c3.addExercise(c);
        c3.addExercise(d);
        List<WorkoutCategory> myList = new ArrayList<WorkoutCategory>();
        myList.add(c1);
        myList.add(c2);
        myList.add(c3);

        List<BannerItem> bannerItemList = new ArrayList<BannerItem>();
        bannerItemList.add(new BannerItem("page 1",android.R.drawable.alert_light_frame));
        bannerItemList.add(new BannerItem("page 2",android.R.drawable.alert_light_frame));
        bannerItemList.add(new BannerItem("page 3",android.R.drawable.alert_light_frame));
        bannerItemList.add(new BannerItem("page 4",android.R.drawable.alert_light_frame));

        mRecyclerView = (RecyclerView) v.findViewById(R.id.detailRecyclerView);
        mRecyclerView.setHasFixedSize(false);//not every row has save size
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);

        adapter = new WorkoutRecyclerAdapter(bannerItemList,myList, getActivity());
        mRecyclerView.setAdapter(adapter);

        if (savedInstanceState != null) {
            // Restore saved layout manager type.
            layoutManager.scrollToPosition(savedInstanceState.getInt(KEY_LAYOUT_MANAGER, 0));

            // restore page position
            adapter.setCurrentPage(savedInstanceState.getInt(KEY_VIEW_PAGER_NUMBER, 0));
        }
        return v;
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(KEY_LAYOUT_MANAGER, ((LinearLayoutManager) mRecyclerView.getLayoutManager())
                .findFirstVisibleItemPosition());
        savedInstanceState.putInt(KEY_VIEW_PAGER_NUMBER, adapter.getBannerPageNumber());
        super.onSaveInstanceState(savedInstanceState);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed() {
        if (mListener != null) {
            mListener.onFragmentInteraction();
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction();
    }

}
