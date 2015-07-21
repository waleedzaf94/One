package com.clarity.one.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.clarity.one.R;
import com.clarity.one.adapters.TopFollowingAdapter;
import com.clarity.one.model.Influencer;

/**
 * Created by Waleed on 7/15/2015.
 */
public class ProfileFragment extends Fragment {

    private String userId;
    private ImageView influencerProfilePic;
    private TextView influencerAvgLikes, influencerFollowersCount, influencerEngagement;

    private RecyclerView profileRecyclerView;
    private TopFollowingAdapter followingAdapter;

    public ProfileFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        userId = getArguments().getString("ActivityUserId");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_influencer_profile, container, false);
        userId = getArguments().getString("ActivityUserId");




        profileRecyclerView = (RecyclerView) rootView.findViewById(R.id.profileRecyclerView);
        influencerProfilePic = (ImageView) rootView.findViewById(R.id.influencerProfilePic);
        influencerAvgLikes = (TextView) rootView.findViewById(R.id.influencerAvgLikes);
        influencerFollowersCount = (TextView) rootView.findViewById(R.id.influencerFollowersCount);
        influencerEngagement = (TextView) rootView.findViewById(R.id.influencerEngagement);
        downloadStuff();
        return rootView;
    }

    private void downloadStuff(){

    }

}
