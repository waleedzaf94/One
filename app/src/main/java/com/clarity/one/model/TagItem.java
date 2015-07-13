package com.clarity.one.model;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

@DynamoDBTable(tableName="TagItem")
public class TagItem {

    private String tag;
    private String userId;

    @DynamoDBHashKey(attributeName = "TagItem")
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

}
