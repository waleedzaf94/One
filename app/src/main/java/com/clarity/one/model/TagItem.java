package com.clarity.one.model;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

@DynamoDBTable(tableName="Tags")
public class TagItem {

    private String tag;
    private String userId;
    private String username;
    private String profilePic;
    private int followersCount;
    private float averageLikes;
    private float engagementRate;

    @DynamoDBHashKey(attributeName = "Tags")
    public String getTag(){
        return tag;
    }

    public void setTag(String t){
        this.tag = t;
    }

    @DynamoDBRangeKey(attributeName = "UserId")
    public String getUserId(){
        return userId;
    }

    public void setUserId(String uid){
        this.userId = uid;
    }

    @DynamoDBAttribute(attributeName = "Username")
    public String getUsername(){
        return username;
    }

    public void setUsername(String u){
        this.username = u;
    }

    @DynamoDBAttribute(attributeName = "ProfilePic")
    public String getProfilePic(){
        return profilePic;
    }

    public void setProfilePic(String pp){
        this.profilePic = pp;
    }

    @DynamoDBAttribute(attributeName = "FollowersCount")
    public int getFollowersCount(){
        return followersCount;
    }

    public void setFollowersCount(int fc){
        this.followersCount = fc;
    }

    @DynamoDBAttribute(attributeName = "AverageLikes")
    public float getAverageLikes(){
        return averageLikes;
    }

    public void setAverageLikes(float av){
        this.averageLikes = av;
    }

    @DynamoDBAttribute(attributeName = "EngagementRate")
    public float getEngagementRate(){
        return engagementRate;
    }

    public void setEngagementRate(float en){
        this.engagementRate = en;
    }

}
