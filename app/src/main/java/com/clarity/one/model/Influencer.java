package com.clarity.one.model;

import android.graphics.drawable.Drawable;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBDocument;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMarshalling;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.JsonMarshaller;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.pkmmte.view.CircularImageView;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Waleed on 7/21/2015.
 */
@DynamoDBTable(tableName="Influencers")
public class Influencer implements Serializable{

    private static final long serialVersionUID = 925333914648562916L;
    private String userId;
    private String username;
    private String website;
    private String bio;
    private String fullName;
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
    private String topCities;
    private Map<String, AttributeValue> topCountries;
    private Map<String, AttributeValue> topFollowing;
    private Map<String, AttributeValue> topTags;
    private Set<String> topMedia;
    private Set<String> topTagList;
    private Set<String> topCountryList;
    private Drawable profilePicture;
    private CircularImageView roundPP;

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

    public void setUsername(String u){
        this.username = u;
    }

    @DynamoDBAttribute(attributeName = "Website")
    public String getWebsite(){
        return website;
    }

    public void setWebsite(String w){
        this.website = w;
    }

    @DynamoDBAttribute(attributeName = "Bio")
    public String getBio(){
        return bio;
    }

    public void setBio(String bio){
        this.bio = bio;
    }

    @DynamoDBAttribute(attributeName = "FullName")
    public String getFullName(){
        return fullName;
    }

    public void setFullName(String f){
        this.fullName = f;
    }

    @DynamoDBAttribute(attributeName = "LastUpdateDate")
    public String getLastUpdateDate(){
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String d){
        this.lastUpdateDate = d;
    }

    @DynamoDBAttribute(attributeName = "MinTagID")
    public String getMinTagId(){
        return minTagId;
    }

    public void setMinTagId(String m){
        this.minTagId = m;
    }

    @DynamoDBAttribute(attributeName = "ProfilePic")
    public String getProfilePic(){
        return profilePic;
    }

    public void setProfilePic(String p){
        this.profilePic = p;
    }

    @DynamoDBAttribute(attributeName = "FollowersCount")
    public int getFollowersCount(){
        return followersCount;
    }

    public void setFollowersCount(int f){
        this.followersCount = f;
    }

    @DynamoDBAttribute(attributeName = "FollowingCount")
    public int getFollowingCount(){
        return followingCount;
    }

    public void setFollowingCount(int ff){
        this.followingCount = ff;
    }

    @DynamoDBAttribute(attributeName = "MediaCount")
    public int getMediaCount(){
        return mediaCount;
    }

    public void setMediaCount(int m){
        this.mediaCount = m;
    }

    @DynamoDBAttribute(attributeName = "AverageLikes")
    public double getAverageLikes(){
        return averageLikes;
    }

    public void setAverageLikes(double a){
        this.averageLikes = a;
    }

    @DynamoDBAttribute(attributeName = "EngagementRate")
    public double getEngagementRate(){
        return engagementRate;
    }

    public void setEngagementRate(double e){
        this.engagementRate = e;
    }

    @DynamoDBAttribute(attributeName = "PostsPerDay")
    public double getPostsPerDay(){
        return postsPerDay;
    }

    public void setPostsPerDay(double p){
        this.postsPerDay = p;
    }

    @DynamoDBAttribute(attributeName = "TotalLikeCount")
    public long getTotalLikeCount(){
        return totalLikeCount;
    }

    public void setTotalLikeCount(long l){
        this.totalLikeCount = l;
    }

    /*@DynamoDBMarshalling(marshallerClass = MarshallerThree.class)
    @DynamoDBAttribute(attributeName = "TopCities")
    public String getTopCities(){
        return topCities;
    }

    public void setTopCities(String m){
        this.topCities = m;
    }

    @DynamoDBMarshalling(marshallerClass = AVMarshaller.class)
    @DynamoDBAttribute(attributeName = "TopCountries")
    public Map<String, AttributeValue> getTopCountries(){
        return topCountries;
    }

    public void setTopCountries(Map<String, AttributeValue> t){
        this.topCountries = t;
    }

    @DynamoDBMarshalling(marshallerClass = AVMarshaller.class)
    @DynamoDBAttribute(attributeName = "TopFollowing")
    public Map<String, AttributeValue> getTopFollowing(){
        return topFollowing;
    }

    public void setTopFollowing(Map<String, AttributeValue> f){
        this.topFollowing = f;
    }

    @DynamoDBMarshalling(marshallerClass = AVMarshaller.class)
    @DynamoDBAttribute(attributeName = "TopTags")
    public Map<String, AttributeValue> getTopTags(){
        return topTags;
    }

    public void setTopTags(Map<String, AttributeValue> t){
        this.topTags = t;
    }
    */
    @DynamoDBAttribute(attributeName = "TopMedia")
    public Set<String> getTopMedia(){
        return topMedia;
    }

    public void setTopMedia(Set<String> m){
        this.topMedia = m;
    }

    @DynamoDBAttribute(attributeName = "TopTagList")
    public Set<String> getTopTagList() {
        return topTagList;
    }

    public void setTopTagList(Set<String> topTagList) {
        this.topTagList = topTagList;
    }

    @DynamoDBAttribute(attributeName = "TopCountryList")
    public Set<String> getTopCountryList() {
        return topCountryList;
    }

    public void setTopCountryList(Set<String> topCountryList) {
        this.topCountryList = topCountryList;
    }

    public Drawable getProfilePicture(){
        return profilePicture;
    }

    public void setProfilePicture(Drawable d){
        this.profilePicture = d;
    }

    public CircularImageView getRoundPP(){
        return roundPP;
    }

    public void setRoundPP(CircularImageView c){
        this.roundPP = c;
    }

}
