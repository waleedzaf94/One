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
 * Created by Waleed on 7/24/2015.
 */
public class PopularPostsAdapter extends RecyclerView.Adapter<PopularPostsAdapter.PopularViewHolder>{


    private LayoutInflater inflater;
    List<FollowingInfo> data = Collections.emptyList();

    public PopularPostsAdapter(Context context, List<FollowingInfo> data){
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public PopularViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.adapter_influencer_profile_following, parent, false);
        PopularViewHolder holder = new PopularViewHolder(view);

        return null;
    }

    @Override
    public void onBindViewHolder(PopularViewHolder holder, int position) {
        FollowingInfo currentObject = data.get(position);
        holder.profilePic.setImageDrawable(currentObject.getProfilePic());
    }

    @Override
    public int getItemCount() {
        return 0;
    }


    class PopularViewHolder extends RecyclerView.ViewHolder{

        ImageView profilePic;

        public PopularViewHolder(View itemView) {
            super(itemView);
            //profilePic = (ImageView) itemView.findViewById(R.id.followingProfilePic);
        }
    }

}
