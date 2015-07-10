package com.clarity.one.aws;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

@DynamoDBTable(tableName="Tags")
public class Tags {

    private String tag;
    private String userId;

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

}
