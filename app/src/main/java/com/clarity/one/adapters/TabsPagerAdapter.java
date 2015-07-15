package com.clarity.one.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.clarity.one.fragments.PopularFragment;
import com.clarity.one.fragments.ProfileFragment;
import com.clarity.one.fragments.RecentFragment;

/**
 * Created by Waleed on 7/15/2015.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int index){

        switch (index){
            case 0:{
                return new ProfileFragment();
            }
            case 1:{
                return new PopularFragment();
            }
            case 2:{
                return new RecentFragment();
            }
        }
        return null;
    }

    @Override
    public int getCount(){
        return 3;
    }

}
