package com.clarity.one.aws;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.*;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.*;


public class TagSearchDB {

    private String tag, tableName="Tags";
    static AmazonDynamoDB dynamoDB;
    static AmazonDynamoDBClient dynamoDBClient;

    public TagSearchDB(String t){
        this.tag = t;
        init();
    }

    private void init(){

    }


}
