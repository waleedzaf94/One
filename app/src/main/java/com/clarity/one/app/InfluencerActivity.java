package com.clarity.one.app;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Locale;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBQueryExpression;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.PaginatedQueryList;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.clarity.one.R;
import com.clarity.one.fragments.PopularFragment;
import com.clarity.one.fragments.ProfileFragment;
import com.clarity.one.fragments.RecentFragment;
import com.clarity.one.model.Influencer;
import com.clarity.one.model.InfluencerOne;
import com.clarity.one.model.ResultItem;
import com.pkmmte.view.CircularImageView;

public class InfluencerActivity extends AppCompatActivity {

    private String userId, username;
    private Influencer influencer;

    private AmazonDynamoDBClient dynamoDBClient;
    private DynamoDBMapper mapper;


    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;
    private ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_influencer);

        Intent i = getIntent();
        userId = i.getStringExtra("InfluencerUserId");
        username = i.getStringExtra("InfluencerUsername");

        initDB();
        influencer = new Influencer();
        influencer.setUserId(userId);
        new runInfluencerQuery(influencer).execute();




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
    }

    private void setInfluencer(Influencer i){
        this.influencer = i;
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.influencerViewPager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
    }

    class runInfluencerQuery extends AsyncTask<Void, Void, PaginatedQueryList<Influencer> > {

        Influencer influencer;

        public runInfluencerQuery(Influencer r){
            this.influencer = r;
        }

        @Override
        protected PaginatedQueryList<Influencer> doInBackground(Void... params){
            try {
                Influencer hashKey = new Influencer();
                hashKey.setUserId(influencer.getUserId());

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
            if (result.size() > 0) {
                this.influencer = result.get(0);
                setInfluencer(influencer);
                //new ImageDownloader(influencer).execute();
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        mActionBar = getSupportActionBar();
        mActionBar.setHomeButtonEnabled(false);
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        mActionBar.setDisplayHomeAsUpEnabled(false);
        mActionBar.setDefaultDisplayHomeAsUpEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);

        View mCustomView = mInflater.inflate(R.layout.actionbar_profile, null);
        TextView profileUsername = (TextView) mCustomView.findViewById(R.id.profileUsername);
        ImageButton profileBack = (ImageButton) mCustomView.findViewById(R.id.profileBack);
        ImageButton profileMore = (ImageButton) mCustomView.findViewById(R.id.profileMore);

        profileUsername.setText(username);
        profileBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);

        Toolbar parent = (Toolbar) mCustomView.getParent();
        parent.setContentInsetsAbsolute(0, 0);

        /*mActionBar = getSupportActionBar();
        mActionBar.setHomeButtonEnabled(false);
        mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        mActionBar.addTab(mActionBar.newTab().setText("Profile"));
        mActionBar.addTab(mActionBar.newTab().setText("Popular"));
        mActionBar.addTab(mActionBar.newTab().setText("Recent"));
        */

        return super.onCreateOptionsMenu(menu);
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Bundle bundle = new Bundle();
            bundle.putString("ActivityUserId", userId);
            bundle.putSerializable("InfluencerObject", influencer);
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position){
                case 0:{
                    ProfileFragment profileFragment = new ProfileFragment();
                    profileFragment.setArguments(bundle);
                    return profileFragment;
                }
                case 1:{
                    PopularFragment popularFragment = new PopularFragment();
                    popularFragment.setArguments(bundle);
                    return popularFragment;
                }
                case 2:{
                    RecentFragment recentFragment = new RecentFragment();
                    recentFragment.setArguments(bundle);
                    return recentFragment;
                }
            }

            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);
                case 2:
                    return getString(R.string.title_section3).toUpperCase(l);
            }
            return null;
        }
    }



}
