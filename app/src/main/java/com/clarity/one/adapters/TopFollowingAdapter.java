package com.clarity.one.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.clarity.one.R;
import com.clarity.one.model.FollowingInfo;

import java.util.Collections;
import java.util.List;

/**
 * Created by Waleed on 7/16/2015.
 */
public class TopFollowingAdapter extends RecyclerView.Adapter<TopFollowingAdapter.FollowingViewHolder> {
//Create adapter. Extend to RecyclerView.Adapter<VH>
//Create custom ViewHolder class as type for RecylcerView.Adapter

    private LayoutInflater inflater;
    List<FollowingInfo> data = Collections.emptyList();

    public TopFollowingAdapter(Context context, List<FollowingInfo> data){
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public FollowingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.influencer_profile_following_item, parent, false);
        FollowingViewHolder holder = new FollowingViewHolder(view);

        return null;
    }

    @Override
    public void onBindViewHolder(FollowingViewHolder holder, int position) {
        FollowingInfo currentObject = data.get(position);
        holder.profilePic.setImageDrawable(currentObject.getProfilePic());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class FollowingViewHolder extends RecyclerView.ViewHolder{

        ImageView profilePic;

        public FollowingViewHolder(View itemView) {
            super(itemView);
            profilePic = (ImageView) itemView.findViewById(R.id.followingProfilePic);
        }
    }

}
