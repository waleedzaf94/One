package com.clarity.one.app;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.clarity.one.R;

public class FilterActivity extends ActionBarActivity {

    private EditText filterLocation;
    private Button filterConfirm;

    private static String fLocation;
    private static int fFollowers;
    private static float fEngagement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        filterLocation = (EditText) findViewById(R.id.filterLocation);
        filterConfirm = (Button) findViewById(R.id.filterConfirm);

        initStuff();

    }

    private void initStuff(){

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        mActionBar.setDisplayHomeAsUpEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);

        View mCustomView = mInflater.inflate(R.layout.actionbar_filter, null);
        TextView mCloseView = (TextView) mCustomView.findViewById(R.id.filtersClear);


        mCloseView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set clear action
            }
        });

        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);

        Toolbar parent = (Toolbar) mCustomView.getParent();
        parent.setContentInsetsAbsolute(0, 0);

        return super.onCreateOptionsMenu(menu);
    }

}
