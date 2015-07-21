package com.clarity.one.app;


import com.clarity.one.adapters.ResultsListAdapter;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.amazonaws.regions.Region;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.*;

import com.clarity.one.R;
import com.clarity.one.model.InfluencerOne;
import com.clarity.one.model.ResultItem;
import com.clarity.one.model.TagItem;

import java.util.ArrayList;
import java.util.List;

public class ResultsActivity extends AppCompatActivity {

    private String tagString;
    private String[] tags;
    private AmazonDynamoDBClient dynamoDBClient;
    private DynamoDBMapper mapper;
    private ListView resultListView;
    private ListAdapter listAdapter;
    private List<TagItem> results;
    protected List<ResultItem> searchResults = new ArrayList<>();
    private Button resultsMoreFiltersBtn;
    public static final String influencerId = "com.clarity.one.app.influencerId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent i = getIntent();
        String message = i.getStringExtra(SearchActivity.ExtraMessage);
        this.tagString = message;
        resultListView = (ListView) findViewById(R.id.resultList);

        resultsMoreFiltersBtn = (Button) findViewById(R.id.resultsMoreFiltersBtn);

        parseTags();
        initStuff();
        initDB();

    }

    private void initStuff(){
        resultsMoreFiltersBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(v.getContext(), FilterActivity.class);
                startActivity(i);

            }
        });

        resultListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TagItem item = (TagItem) resultListView.getItemAtPosition(position);
                String uid = item.getUserId();
                Intent i = new Intent(getApplicationContext(), InfluencerActivity.class);
                i.putExtra(influencerId, uid);
                startActivity(i);
            }
        });
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
        listAdapter = new ResultsListAdapter(getApplicationContext(), result);
        resultListView.setAdapter(listAdapter);
        /*Iterator k = result.iterator();
        TagItem item = null;
        while (k.hasNext()){
            item = (TagItem) k.next();
            ResultItem resultItem = new ResultItem(item.getTag(), item.getUserId());
            searchResults.add(resultItem);
            Log.e("ITEM: ", item.getUserId());
        }*/
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

    class runInfluencerQuery extends AsyncTask<Void, Void, PaginatedQueryList<InfluencerOne> >{

        ResultItem resultItem;

        public runInfluencerQuery(ResultItem r){
            this.resultItem = r;
        }

        @Override
        protected PaginatedQueryList<InfluencerOne> doInBackground(Void... params){
            try {
                InfluencerOne hashKey = new InfluencerOne();
                hashKey.setUserId(resultItem.getUserId());

                DynamoDBQueryExpression queryExpression = new DynamoDBQueryExpression()
                        .withHashKeyValues(hashKey);

                PaginatedQueryList<InfluencerOne> result = mapper.query(InfluencerOne.class, queryExpression);

                return result;
            } catch (Exception e){
                String er = e.getMessage();
                if (e != null)
                    Log.e("InfluencerOne AWS Error", er);
                else
                    Log.e("InfluencerOne AWS Error", "No detailed message available");
            }
            return null;
        }

        protected void onPostExecute(PaginatedQueryList<InfluencerOne> result){

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        mActionBar.setDisplayHomeAsUpEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);

        View mCustomView = mInflater.inflate(R.layout.actionbar_results, null);
        TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.resultsSearchNameL);
        TextView mCloseView = (TextView) mCustomView.findViewById(R.id.resultsCloseL);

        mTitleTextView.setText(tagString);

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
