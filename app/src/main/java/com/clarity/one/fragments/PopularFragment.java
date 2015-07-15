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
public class PopularFragment extends Fragment {

    public PopularFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_influencer_popular, container, false);

        return rootView;
    }

}
