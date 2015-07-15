package com.clarity.one.app;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.clarity.one.R;

import org.w3c.dom.Text;

public class FilterActivity extends ActionBarActivity {

    private EditText filterLocation;
    private Button filterConfirm;
    private Spinner filterFollowersSpinner, filterEngagementSpinner;
    private ImageButton filterBack;
    private TextView filterClear;
    private static String fLocation;
    private static int fFollowers;
    private static double fEngagement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        filterLocation = (EditText) findViewById(R.id.filterLocation);
        filterConfirm = (Button) findViewById(R.id.filterConfirm);
        filterFollowersSpinner = (Spinner) findViewById(R.id.filterFollowersSpinner);
        filterEngagementSpinner = (Spinner) findViewById(R.id.filterEngagementSpinner);
        filterBack = (ImageButton) findViewById(R.id.filterBack);
        filterClear = (TextView) findViewById(R.id.filterClear);

        initStuff();

    }

    private void initStuff(){
        filterFollowersSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:{
                        fFollowers = 1000;
                        break;
                    }
                    case 1:{
                        fFollowers = 2000;
                        break;
                    }
                    case 2:{
                        fFollowers = 5000;
                        break;
                    }
                    case 3:{
                        fFollowers = 10000;
                        break;
                    }
                    case 4:{
                        fFollowers = 20000;
                        break;
                    }
                    case 5:{
                        fFollowers = 50000;
                        break;
                    }
                    case 6:{
                        fFollowers = 100000;
                        break;
                    }
                    case 7:{
                        fFollowers = 200000;
                        break;
                    }
                    case 8:{
                        fFollowers = 500000;
                        break;
                    }
                    case 9:{
                        fFollowers = 1000000;
                        break;
                    }
                    case 10:{
                        fFollowers = 2000000;
                        break;
                    }
                    case 11:{
                        fFollowers = 5000000;
                        break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        filterEngagementSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: {
                        fEngagement = 0.5;
                        break;
                    }
                    case 1: {
                        fEngagement = 1;
                        break;
                    }
                    case 2: {
                        fEngagement = 2;
                        break;
                    }
                    case 3: {
                        fEngagement = 3;
                        break;
                    }
                    case 4: {
                        fEngagement = 4;
                        break;
                    }
                    case 5: {
                        fEngagement = 5;
                        break;
                    }
                    case 6: {
                        fEngagement = 10;
                        break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        filterConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constants.followersThreshold = fFollowers;
                Constants.engagementThreshold = fEngagement;
                Constants.filters = true;
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        mActionBar.setDisplayHomeAsUpEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);

        View mCustomView = mInflater.inflate(R.layout.actionbar_filter, null);
        filterClear = (TextView) mCustomView.findViewById(R.id.filterClear);
        filterBack = (ImageButton) mCustomView.findViewById(R.id.filterBack);

        filterClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearStuff();
            }
        });

        filterBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearStuff();
                finish();
            }
        });

        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);

        Toolbar parent = (Toolbar) mCustomView.getParent();
        parent.setContentInsetsAbsolute(0, 0);

        return super.onCreateOptionsMenu(menu);
    }

    private void clearStuff(){
        fLocation=null;
        fFollowers=0;
        fEngagement=0;
        filterLocation.setText("");
        filterFollowersSpinner.setSelection(0);
        filterEngagementSpinner.setSelection(0);
        Constants.followersThreshold=0;
        Constants.engagementThreshold=0;
        Constants.filterLocations=null;
        Constants.filters=false;
    }

}
