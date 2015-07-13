package com.clarity.one.app;


import com.clarity.one.adapters.resultsListAdapter;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.amazonaws.regions.Region;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.*;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.clarity.one.R;
import com.clarity.one.model.Influencer;
import com.clarity.one.model.TagItem;

import java.util.ArrayList;
import java.util.Iterator;

public class ResultsActivity extends ActionBarActivity {

    private String tagString;
    private String[] tags;
    private AmazonDynamoDBClient dynamoDBClient;
    private DynamoDBMapper mapper;
    private ListView resultListView;
    private ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        

        Intent i = getIntent();
        String message = i.getStringExtra(SearchActivity.ExtraMessage);
        this.tagString = message;
        resultListView = (ListView) findViewById(R.id.resultList);
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
                String qTag = tags[i];

                new runTagsQuery().execute(tags[i]);

            } catch (Exception e){
                String er = e.getMessage();
                if (e != null)
                    Log.e("AWS Error", e.getMessage());
            }
        }

    }

    private void displayResult(PaginatedQueryList<TagItem> result){
        listAdapter = new resultsListAdapter(getApplicationContext(), result);
        resultListView.setAdapter(listAdapter);
        Iterator k = result.iterator();
        TagItem item = null;
        while (k.hasNext()){
            item = (TagItem) k.next();
            Log.e("ITEM: ", item.getUserId());
        }
    }

    class runTagsQuery extends AsyncTask<String, Void, PaginatedQueryList<TagItem>>{

        @Override
        protected PaginatedQueryList<TagItem> doInBackground(String... params){
                try {
                    TagItem hashKey = new TagItem();
                    hashKey.setTag(params[0]);

                    DynamoDBQueryExpression queryExpression = new DynamoDBQueryExpression()
                            .withHashKeyValues(hashKey);

                    PaginatedQueryList<TagItem> result = mapper.query(TagItem.class, queryExpression);

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

        protected void onPostExecute(PaginatedQueryList<TagItem> result){
            displayResult(result);
        }


    }

    class runInfluencerQuery extends AsyncTask<String, Void, PaginatedQueryList<Influencer> >{

        @Override
        protected PaginatedQueryList<Influencer> doInBackground(String... params){
            try {
                Influencer hashKey = new Influencer();
                hashKey.setUserId(params[0]);

                DynamoDBQueryExpression queryExpression = new DynamoDBQueryExpression()
                        .withHashKeyValues(hashKey);

                PaginatedQueryList<Influencer> result = mapper.query(Influencer.class, queryExpression);

                return result;
            } catch (Exception e){
                String er = e.getMessage();
                if (e != null)
                    Log.e("Influencer AWS Error", er);
                else
                    Log.e("Influencer AWS Error", "No detailed message available");
            }
            return null;
        }

        protected void onPostExecute(PaginatedQueryList<Influencer> result){

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
