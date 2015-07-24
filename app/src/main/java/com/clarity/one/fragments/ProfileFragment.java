package com.clarity.one.fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.clarity.one.R;
import com.clarity.one.adapters.TopFollowingAdapter;
import com.clarity.one.model.Influencer;
import com.pkmmte.view.CircularImageView;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Set;

/**
 * Created by Waleed on 7/15/2015.
 */
public class ProfileFragment extends Fragment {

    private String userId;
    private Influencer influencer;
    private CircularImageView influencerProfilePic;
    private TextView influencerAvgLikes, influencerFollowersCount, influencerEngagement, influencerBio, influencerPosts;
    private TextView influencerTags, influencerLocations, influencerPostsLabel, influencerTagsLabel, influencerLocationsLabel;

    public ProfileFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_influencer_profile, container, false);
        userId = getArguments().getString("ActivityUserId");
        influencer = (Influencer) getArguments().getSerializable("InfluencerObject");


        influencerProfilePic = (CircularImageView) rootView.findViewById(R.id.influencerProfilePic);
        influencerAvgLikes = (TextView) rootView.findViewById(R.id.influencerAvgLikes);
        influencerFollowersCount = (TextView) rootView.findViewById(R.id.influencerFollowersCount);
        influencerEngagement = (TextView) rootView.findViewById(R.id.influencerEngagement);
        influencerBio = (TextView) rootView.findViewById(R.id.profileBio);
        influencerPostsLabel = (TextView) rootView.findViewById(R.id.profilePostsLabel);
        influencerPosts = (TextView) rootView.findViewById(R.id.profilePosts);
        influencerTagsLabel = (TextView) rootView.findViewById(R.id.profileTopTagsLabel);
        influencerLocationsLabel = (TextView) rootView.findViewById(R.id.profileTopLocationsLabel);

        double avg = influencer.getAverageLikes();
        int followers = influencer.getFollowersCount();
        double engagement = influencer.getEngagementRate();
        String bio = influencer.getBio();
        String website = influencer.getWebsite();
        double posts = influencer.getPostsPerDay();
        int mediaCount = influencer.getMediaCount();
        Set<String> tags = influencer.getTopTagList();
        Set<String> countries = influencer.getTopCountryList();

        if (avg > -1) influencerAvgLikes.setText(String.format("%.2f", avg));
        if (followers > -1) influencerFollowersCount.setText(formatFollowers(followers));
        if (engagement > -1) influencerEngagement.setText(String.format("%.2f", engagement));
        if (!(bio.equals("N/A"))){
            if (!(website.equals("N/A")))
                influencerBio.setText(bio + "\n" + website);
            else
                influencerBio.setText(bio);
        }
        else{
            if (!(bio.equals("N/A")))
                influencerBio.setText(website);
            else
                influencerBio.setText("");
        }
        influencerPosts.setText(Integer.toString(mediaCount) + " (" + String.format("%.2f", posts ) + " posts/day)");

        new ImageDownloader(influencer.getProfilePic()).execute();

        return rootView;
    }

    private String formatFollowers(int followers){
        String fs = Integer.toString(followers);
        if (followers > 999999){
            int len = fs.length();
            int sixthLast = len-6;
            char sl = fs.charAt(sixthLast);
            String start = fs.substring(0, sixthLast);
            String num = start + "." + sl + "m";
            return num;
        }
        else if (followers > 999){
            int len = fs.length();
            int thirdLast = len-3;
            char tl = fs.charAt(thirdLast);
            String start = fs.substring(0, thirdLast);
            String num = start + "." + tl + "k";
            return num;
        }
        return fs;
    }

    private void setProfilePic(Drawable image){
        influencer.setProfilePicture(image);
        influencerProfilePic.setImageDrawable(image);
    }

    class ImageDownloader extends AsyncTask<Void, Void, Void> {
        private String url;
        private Drawable drawable;

        public ImageDownloader(String url){
            this.url = url;
        }

        protected Void doInBackground(Void... params){
            drawable = downloadImage(url);
            return null;
        }

        protected void onPostExecute(Void param){
            setProfilePic(drawable);
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
                Log.e("Error downloading image", e.toString());
            }
            return null;
        }

    }

}
