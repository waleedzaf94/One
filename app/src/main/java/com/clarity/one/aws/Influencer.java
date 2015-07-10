package com.clarity.one.aws;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

@DynamoDBTable(tableName="Influencers")
public class Influencer {

    private String userId;
    private int followersCount;
    private int followingCount;
    private String fullName;
    private int mediaCount;
    private String username;

    @DynamoDBHashKey(attributeName = "UserId")
    public String getUserId(){
        return userId;
    }

    public void setUserId(String u){
        this.userId = u;
    }

    @DynamoDBAttribute(attributeName = "Followers Count")
    public int getFollowersCount(){
        return followersCount;
    }

    public void setFollowersCount(int i){
        this.followersCount = i;
    }

    @DynamoDBAttribute(attributeName = "Following Count")
    public int getFollowingCount(){
        return followingCount;
    }

    public void setFollowingCount(int i){
        this.followingCount = i;
    }

    @DynamoDBAttribute(attributeName = "Full Name")
    public String getFullName(){
        return fullName;
    }

    public void setFullName(String f){
        this.fullName = f;
    }

    @DynamoDBAttribute(attributeName = "Media Count")
    public int getMediaCount(){
        return mediaCount;
    }

    public void setMediaCount(int i){
        this.mediaCount = i;
    }

    @DynamoDBAttribute(attributeName = "Username")
    public String getUsername(){
        return username;
    }

    public void setUsername(String u){
        this.username = u;
    }

}
