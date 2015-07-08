package com.clarity.one.app;

import android.app.Activity;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.clarity.one.R;


public class ListsActivity extends Activity {

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
    }

    private void popList(){

    }

}
