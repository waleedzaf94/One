package com.clarity.one.app;


import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.amazonaws.regions.Region;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.*;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.*;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.clarity.one.R;
import com.clarity.one.aws.Tags;

import java.util.Iterator;

public class ResultsActivity extends ActionBarActivity {

    private String tagString;
    private String[] tags;
    private AmazonDynamoDBClient dynamoDBClient;
    DynamoDBMapper mapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent i = getIntent();
        String message = i.getStringExtra(SearchActivity.ExtraMessage);
        this.tagString = message;
        parseTags();
        initDB();

    }

    private void parseTags(){
        tags = tagString.split("\\s+");
        for (int i=0; i<tags.length; i++){
            tags[i] = tags[i].toLowerCase();
        }
    }

    private void initDB(){
        CognitoCachingCredentialsProvider credentialsProvider = new CognitoCachingCredentialsProvider(
                getApplicationContext(),
                "us-east-1:e492ecec-e868-40f8-a83e-0132c780a083",
                Regions.US_EAST_1
        );
        dynamoDBClient = new AmazonDynamoDBClient(credentialsProvider);
        dynamoDBClient.setRegion(Region.getRegion(Regions.US_WEST_2));
        mapper = new DynamoDBMapper(dynamoDBClient);
        getTags();
    }

    private void getTags(){
        for (int i=0; i<tags.length; i++){
            try {
                Tags tagResult = new Tags();
                String qTag = tags[i];
                Condition condition = new Condition()
                        .withComparisonOperator(ComparisonOperator.CONTAINS.toString())
                        .withAttributeValueList(new AttributeValue().withS(qTag.toString()));

                new runQuery().execute(tags[i]);

                /*
                DynamoDBQueryExpression queryExpression = new DynamoDBQueryExpression()
                        .withRangeKeyCondition("Tags", condition)
                        .withConsistentRead(false);

                Tags hash = new Tags();
                hash.setTag(qTag);

                Object qd = new DynamoDBQueryExpression()
                        .getHashKeyValues();

                DynamoDBQueryExpression qe = new DynamoDBQueryExpression()
                        .withHashKeyValues(hash);

                qe.setHashKeyValues(hash);

                DynamoDBQueryExpression qf = new DynamoDBQueryExpression()
                        .withHashKeyValues(qTag);

                //Tags sTag = mapper.load(Tags.class, qTag);

                PaginatedQueryList<Tags> result = mapper.query(Tags.class, qe);
                */
            } catch (Exception e){
                String er = e.getMessage();
                if (e != null)
                    Log.e("AWS Error", e.getMessage());
            }
        }

    }

    private void displayResult(PaginatedQueryList<Tags> result){
        Iterator k = result.iterator();
        Tags item = null;
        while (k.hasNext()){
            item = (Tags) k.next();
            Log.e("ITEM: ", item.getUserId());
        }
    }


    class runQuery extends AsyncTask<String, Void, PaginatedQueryList<Tags>>{

        @Override
        protected PaginatedQueryList<Tags> doInBackground(String... params){
                try {
                    Tags hashKey = new Tags();
                    hashKey.setTag(params[0]);

                    DynamoDBQueryExpression queryExpression = new DynamoDBQueryExpression()
                            .withHashKeyValues(hashKey);

                    PaginatedQueryList<Tags> result = mapper.query(Tags.class, queryExpression);

                    return result;
                } catch (Exception e){
                    String er = e.getMessage();
                    if (e != null)
                        Log.e("AWS Error", er);
                    else
                        Log.e("AWS Error", "No detailed message available");
                }
            return null;
        }

        protected void onPostExecute(PaginatedQueryList<Tags> result){
            displayResult(result);
        }


    }



    class resultsListAdapter extends BaseAdapter{

        @Override
        public int getCount(){
            return 1;
        }

        @Override
        public String getItem(int position){
            return "";
        }

        @Override
        public long getItemId(int position){
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            return null;
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        mActionBar.setDisplayHomeAsUpEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);

        View mCustomView = mInflater.inflate(R.layout.results_actionbar, null);
        TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.resultsSearchNameL);
        TextView mCloseView = (TextView) mCustomView.findViewById(R.id.resultsCloseL);

        mCloseView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);

        Toolbar parent = (Toolbar) mCustomView.getParent();
        parent.setContentInsetsAbsolute(0, 0);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.resultsSearchName:{
                //Do nothing
            }
            case R.id.resultsClose:{
                finish(); //Close results page
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
