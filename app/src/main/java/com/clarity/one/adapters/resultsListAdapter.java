package com.clarity.one.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.PaginatedQueryList;
import com.clarity.one.R;
import com.clarity.one.model.TagItem;
import com.pkmmte.view.CircularImageView;

/**
 * Created by Waleed on 7/12/2015.
 */
public class resultsListAdapter extends ArrayAdapter<TagItem> {

    public resultsListAdapter(Context context, PaginatedQueryList<TagItem> queryList){
        super(context, R.layout.result_list_item, queryList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflator = LayoutInflater.from(getContext());
        View customView = inflator.inflate(R.layout.result_list_item, parent, false);
        TagItem tagItem = getItem(position);
        TextView username = (TextView) customView.findViewById(R.id.resultListUsername);
        CircularImageView profilePic = (CircularImageView) customView.findViewById(R.id.resultListPic);
        TextView followersCount = (TextView) customView.findViewById(R.id.resultListFollowers);
        TextView avgLikes = (TextView) customView.findViewById(R.id.resultListLikes);
        TextView engagement = (TextView) customView.findViewById(R.id.resultListEngagement);
        TextView tags = (TextView) customView.findViewById(R.id.resultListTags);
        username.setText(tagItem.getUserId());
        return customView;
    }



}