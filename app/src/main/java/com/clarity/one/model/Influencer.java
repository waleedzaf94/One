package com.clarity.one.model;

import android.graphics.drawable.Drawable;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Waleed on 7/21/2015.
 */
public class Influencer implements Serializable{

    private String userId;
    private String username;
    private String website;
    private String bio;
    private String fullname;
    private String lastUpdateDate;
    private String minTagId;
    private String profilePic;
    private int followersCount;
    private int followingCount;
    private int mediaCount;
    private double averageLikes;
    private double engagementRate;
    private double postsPerDay;
    private long totalLikeCount;
    private Map<String, AttributeValue> topCities;
    private Map<String, AttributeValue> topCountries;
    private Map<String, AttributeValue> topFollowing;
    private Map<String, AttributeValue> topTags;
    private List<String> topMedia;
    private Drawable profilePicture;

    @DynamoDBHashKey(attributeName = "UserId")
    public String getUserId(){
        return userId;
    }

    public void setUserId(String u){
        this.userId = u;
    }

    @DynamoDBAttribute(attributeName = "Username")
    public String getUsername(){
        return username;
    }

    @DynamoDBAttribute(attributeName = "Website")
    public String getWebsite(){
        return website;
    }

    @DynamoDBAttribute(attributeName = "Bio")
    public String getBio(){
        return bio;
    }

    @DynamoDBAttribute(attributeName = "FullName")
    public String getFullName(){
        return fullname;
    }

    @DynamoDBAttribute(attributeName = "LastUpdateDate")
    public String getLastUpdateDate(){
        return lastUpdateDate;
    }

    @DynamoDBAttribute(attributeName = "MinTagID")
    public String getMinTagId(){
        return minTagId;
    }

    @DynamoDBAttribute(attributeName = "ProfilePic")
    public String getProfilePic(){
        return profilePic;
    }

    @DynamoDBAttribute(attributeName = "FollowersCount")
    public int getFollowersCount(){
        return followersCount;
    }

    @DynamoDBAttribute(attributeName = "FollowingCount")
    public int getFollowingCount(){
        return followingCount;
    }

    @DynamoDBAttribute(attributeName = "MediaCount")
    public int getMediaCount(){
        return mediaCount;
    }

    @DynamoDBAttribute(attributeName = "AverageLikes")
    public double getAverageLikes(){
        return averageLikes;
    }

    @DynamoDBAttribute(attributeName = "EngagementRate")
    public double getEngagementRate(){
        return engagementRate;
    }

    @DynamoDBAttribute(attributeName = "PostsPerDay")
    public double getPostsPerDay(){
        return postsPerDay;
    }

    @DynamoDBAttribute(attributeName = "TotalLikeCount")
    public long getTotalLikeCount(){
        return totalLikeCount;
    }

    @DynamoDBAttribute(attributeName = "TopCities")
    public Map<String, AttributeValue> getTopCities(){
        return topCities;
    }

    @DynamoDBAttribute(attributeName = "TopCountries")
    public Map<String, AttributeValue> getTopCountries(){
        return topCountries;
    }

    @DynamoDBAttribute(attributeName = "TopFollowing")
    public Map<String, AttributeValue> getTopFollowing(){
        return topFollowing;
    }

    @DynamoDBAttribute(attributeName = "TopTags")
    public Map<String, AttributeValue> getTopTags(){
        return topTags;
    }

    @DynamoDBAttribute(attributeName = "TopMedia")
    public List<String> getTopMedia(){
        return topMedia;
    }

    public Drawable getProfilePicture(){
        return profilePicture;
    }

    public void setProfilePicture(Drawable d){
        this.profilePicture = d;
    }

}
