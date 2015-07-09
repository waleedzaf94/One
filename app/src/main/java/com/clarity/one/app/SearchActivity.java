package com.clarity.one.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.clarity.one.R;

import java.util.List;

public class SearchActivity extends Activity {

    EditText searchKeywordsET;
    Button searchCancelBtn, searchClearHistoryBtn;
    ImageButton searchSearchBtn;
    ListView searchListView;
    TextView searchPopularTags [] = new TextView[10];
    public final static String ExtraMessage = "com.clarity.one.app.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);



        searchKeywordsET = (EditText) findViewById(R.id.searchKeywordsET);
        searchCancelBtn = (Button) findViewById(R.id.searchCancelBtn);
        searchClearHistoryBtn = (Button) findViewById(R.id.searchClearHistoryBtn);
        searchSearchBtn = (ImageButton) findViewById(R.id.searchSearchBtn);
        searchListView = (ListView) findViewById(R.id.searchListView);
        searchPopularTags[0] = (TextView) findViewById(R.id.searchTravel);
        searchPopularTags[1] = (TextView) findViewById(R.id.searchLifestyle);
        searchPopularTags[2] = (TextView) findViewById(R.id.searchFood);
        searchPopularTags[3] = (TextView) findViewById(R.id.searchBeauty);
        searchPopularTags[4] = (TextView) findViewById(R.id.searchFashion);
        searchPopularTags[5] = (TextView) findViewById(R.id.searchSports);
        searchPopularTags[6] = (TextView) findViewById(R.id.searchCars);

        initStuff();
    }



    private void initStuff(){

        searchSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ResultsActivity.class);
                String message = searchKeywordsET.getText().toString();
                message = message.trim();
                if (message != ""){
                    i.putExtra(ExtraMessage, message);
                    startActivity(i);
                }
                else{
                    Context context = getApplicationContext();
                    CharSequence text = "Please enter a tag.";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });

        searchCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        searchPopularTags[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchKeywordsET.setText(searchKeywordsET.getText().toString() + " " + searchPopularTags[0].getText());
            }
        });
        searchPopularTags[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchKeywordsET.setText(searchKeywordsET.getText().toString() + " " + searchPopularTags[1].getText());
            }
        });
        searchPopularTags[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchKeywordsET.setText(searchKeywordsET.getText().toString() + " " + searchPopularTags[2].getText());
            }
        });
        searchPopularTags[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchKeywordsET.setText(searchKeywordsET.getText().toString() + " " + searchPopularTags[3].getText());
            }
        });
        searchPopularTags[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchKeywordsET.setText(searchKeywordsET.getText().toString() + " " + searchPopularTags[4].getText());
            }
        });
        searchPopularTags[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchKeywordsET.setText(searchKeywordsET.getText().toString() + " " + searchPopularTags[5].getText());
            }
        });
        searchPopularTags[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchKeywordsET.setText(searchKeywordsET.getText().toString() + " " + searchPopularTags[6].getText());
            }
        });

    }

}
