package com.clarity.one.model;

import android.graphics.drawable.Drawable;

/**
 * Created by Waleed on 7/16/2015.
 */
public class FollowingInfo {

    private String profilePicURL;
    private Drawable profilePic;
    private double followerCount;

    public String getProfilePicURL(){
        return profilePicURL;
    }

    public void setProfilePicURL(String p){
        this.profilePicURL = p;
    }

    public Drawable getProfilePic(){
        return profilePic;
    }

    public void setProfilePic(Drawable d){
        this.profilePic = d;
    }
    
    public double getFollowerCount(){
        return followerCount;
    }

    public void setFollowerCount(double f){
        this.followerCount = f;
    }

}
