package com.clarity.one.model;

import com.pkmmte.view.CircularImageView;

/**
 * Created by Waleed on 7/12/2015.
 */
public class ResultItem {

    private CircularImageView profilePic;
    private String username;
    private String followersCount;
    private String averageLikes;
    private String engagement;
    private String [] tags;
    private String origTag;

    public CircularImageView getProfilePic(){
        return profilePic;
    }

    public void setProfilePic(CircularImageView p){
        this.profilePic = p;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String u){
        this.username = u;
    }

    public String getFollowersCount(){
        return followersCount;
    }

    public void setFollowersCount(String f){
        this.followersCount = f;
    }

    public String getAverageLikes(){
        return averageLikes;
    }

    public void setAverageLikes(String a){
        this.averageLikes = a;
    }

    public String getEngagement(){
        return engagement;
    }

    public void setEngagement(String e){
        this.engagement = e;
    }

    public String [] getTags(){
        return tags;
    }

    public void setTags(String [] t){
        this.tags = t;
    }

    public String getOrigTag(){
        return origTag;
    }

    public void setOrigTag(String t){
        this.origTag = t;
    }

}
