package com.clarity.one.model;

import android.graphics.drawable.Drawable;

/**
 * Created by Waleed on 7/24/2015.
 */
public class MediaPost {

    private int likeCount;
    private int comments;
    private String location;
    private String caption;
    private String mediaId;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private Drawable picture;

    public Drawable getPicture() {
        return picture;
    }

    public void setPicture(Drawable picture) {
        this.picture = picture;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
