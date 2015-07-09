package com.clarity.one.app;


import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.clarity.one.R;

public class ResultsActivity extends ActionBarActivity {

    private String tagString;
    private String[] tags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent i = getIntent();
        String message = i.getStringExtra(SearchActivity.ExtraMessage);
        this.tagString = message;
        parseTags();


    }

    private void parseTags(){
        tags = tagString.split("\\s+");
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
