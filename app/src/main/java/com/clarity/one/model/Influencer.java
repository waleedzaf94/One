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

    public class City {
        CityMap m;

        public CityMap getM() {
            return m;
        }

        public void setM(CityMap m) {
            this.m = m;
        }
    }

    public class CityMap {
        List<MS> cityList;

        public List<MS> getCityList() {
            return cityList;
        }

        public void setCityList(List<MS> cityList) {
            this.cityList = cityList;
        }
    }

    public class MS {
        String cityName;
        SNValue attributeValue;

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public void setAttributeValue(SNValue attributeValue) {
            this.attributeValue = attributeValue;
        }

        public SNValue getAttributeValue() {
            return attributeValue;
        }
    }

    public class SNValue {
        int N;

        public int getN() {
            return N;
        }

        public void setN(int n) {
            this.N = n;
        }
    }

    public class AVMarshaller extends JsonMarshaller<City>{

        @Override
        public String marshall(City obj) {
            return super.marshall(obj);
        }

        @Override
        public City unmarshall(Class<City> clazz, String json) {
            return super.unmarshall(clazz, json);
        }

    }

    public class MarshallerTwo extends JsonMarshaller<Map<String, String>>{

    }

    public class MarshallerThree extends JsonMarshaller<String> {

        public String marshall(String obj) {
            return super.marshall(obj);
        }


        public String unmarshall(Class<String> clazz, String json) {
            return super.unmarshall(clazz, json);
        }
    }

}
