package com.clarity.one.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.clarity.one.R;
import com.clarity.one.fragments.ProfileFragment;
import com.clarity.one.model.MediaPost;

import java.util.Collections;
import java.util.List;

/**
 * Created by Waleed on 7/24/2015.
 */
public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.PopularViewHolder>{


    private LayoutInflater inflater;
    List<MediaPost> data = Collections.emptyList();
    private RecyclerView mRecyclerView;

    public PopularAdapter(Context context, List<MediaPost> data){
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public PopularViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.adapter_popular_post, parent, false);
        PopularViewHolder holder = new PopularViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(PopularViewHolder holder, int position) {
        MediaPost currPost = data.get(position);

        holder.popularLikes.setText(ProfileFragment.formatFollowers(currPost.getLikeCount()));
        holder.popularLocation.setText(currPost.getLocation());
        holder.popularCaption.setText(currPost.getCaption());
        holder.popularComments.setText(Integer.toString(currPost.getComments()) + " comments");
        if (currPost.getPicture() != null) holder.picture.setImageDrawable(currPost.getPicture());
        //holder.profilePic.setImageDrawable(currentObject.getProfilePic());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class PopularViewHolder extends RecyclerView.ViewHolder{

        ImageView picture;
        TextView popularLikes, popularLocation, popularCaption, popularComments;

        public PopularViewHolder(View itemView) {
            super(itemView);
            picture = (ImageView) itemView.findViewById(R.id.popularPic);
            popularLikes = (TextView) itemView.findViewById(R.id.popularLikes);
            popularLocation = (TextView) itemView.findViewById(R.id.popularLocation);
            popularCaption = (TextView) itemView.findViewById(R.id.popularCaption);
            popularComments = (TextView) itemView.findViewById(R.id.popularComments);
        }
    }

}
