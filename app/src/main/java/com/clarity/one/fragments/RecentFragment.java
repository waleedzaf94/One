package com.clarity.one.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.clarity.one.R;

/**
 * Created by Waleed on 7/15/2015.
 */
public class RecentFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    public RecentFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_influencer_recent, container, false);

        return rootView;
    }

    public static PopularFragment newInstance(int sectionNumber) {
        PopularFragment fragment = new PopularFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

}
