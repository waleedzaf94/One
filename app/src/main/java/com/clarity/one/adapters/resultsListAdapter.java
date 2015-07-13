package com.clarity.one.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.PaginatedQueryList;
import com.clarity.one.R;
import com.clarity.one.model.TagItem;
import com.pkmmte.view.CircularImageView;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by Waleed on 7/12/2015.
 */
public class resultsListAdapter extends ArrayAdapter<TagItem> {

    public resultsListAdapter(Context context, PaginatedQueryList<TagItem> queryList){
        super(context, R.layout.list_item_results, queryList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflator = LayoutInflater.from(getContext());
        View customView = inflator.inflate(R.layout.list_item_results, parent, false);
        TagItem tagItem = getItem(position);
        TextView username = (TextView) customView.findViewById(R.id.resultListUsername);
        CircularImageView profilePic = (CircularImageView) customView.findViewById(R.id.resultListPic);
        TextView followersCount = (TextView) customView.findViewById(R.id.resultListFollowers);
        TextView avgLikes = (TextView) customView.findViewById(R.id.resultListLikes);
        TextView engagement = (TextView) customView.findViewById(R.id.resultListEngagement);
        TextView tags = (TextView) customView.findViewById(R.id.resultListTags);
        username.setText(tagItem.getUsername());
        followersCount.setText(Integer.toString(tagItem.getFollowersCount()));
        avgLikes.setText(Float.toString(tagItem.getAverageLikes()));
        engagement.setText(Float.toString(tagItem.getEngagementRate()));
        ImageDownloader imageDownloader = new ImageDownloader(profilePic, tagItem.getProfilePic());
        imageDownloader.execute();
        return customView;
    }

    class ImageDownloader extends AsyncTask<Void, Void, Void> {
        private CircularImageView profilePic;
        private Drawable drawable;
        private String url;

        public ImageDownloader(CircularImageView pp, String u){
            this.profilePic = pp;
            this.url = u;
        }

        protected Void doInBackground(Void... params){
            drawable = downloadImage(url);
            return null;
        }

        protected void onPostExecute(Void param){
            profilePic.setImageDrawable(drawable);
        }

        private Drawable downloadImage(String url1){
            URL url;
            InputStream in;
            BufferedInputStream buf;

            try{
                url = new URL(url1);
                in = url.openStream();

                buf = new BufferedInputStream(in);

                Bitmap bmap = BitmapFactory.decodeStream(buf);
                if (in != null){
                    in.close();
                }
                if (buf != null){
                    buf.close();
                }
                return new BitmapDrawable(bmap);
            } catch (Exception e){
                Log.v("Error downloading image", e.toString());
            }
            return null;
        }

    }



}