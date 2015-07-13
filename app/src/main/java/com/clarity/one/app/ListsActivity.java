package com.clarity.one.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.clarity.one.R;


public class ListsActivity extends ActionBarActivity {

    private ImageButton listsSettings, listsSearch;
    private TextView listsUsername, listsCreateListTV;
    private ImageView listsProfilePic, listsCreateList;
    private ListView listsListView;
    private RelativeLayout listsCreateListRL;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lists);

        listsSettings = (ImageButton) findViewById(R.id.listsSettings);
        listsSearch = (ImageButton) findViewById(R.id.listsSearch);
        listsUsername = (TextView) findViewById(R.id.listsUsername);
        listsCreateListTV = (TextView) findViewById(R.id.listsCreateListTV);
        listsProfilePic = (ImageView) findViewById(R.id.listsProfilePic);
        listsCreateList = (ImageView) findViewById(R.id.listsCreateList);
        listsListView = (ListView) findViewById(R.id.listsListView);
        listsCreateListRL = (RelativeLayout) findViewById(R.id.listsCreateListRL);

        popList();
        initStuff();
    }

    private void popList(){

    }

    private void initStuff(){
        listsSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), SearchActivity.class);
                startActivity(i);
            }
        });
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu){

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        mActionBar.setDisplayHomeAsUpEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);

        View mCustomView = mInflater.inflate(R.layout.actionbar_lists, null);

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
            case R.id.listsSettings:{
                //Do Something
            }
        }

        return super.onOptionsItemSelected(item);
    }
    */

}
