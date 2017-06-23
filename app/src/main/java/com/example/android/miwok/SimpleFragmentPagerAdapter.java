package com.example.android.miwok;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Carlos on 6/22/2017.
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter
{
    private static final int NUM_OF_TABS = 4;
    private String tabTitles[] = new String[] {
                    "Numbers",
                    "Colors",
                    "Family",
                    "Phrases" };



    public SimpleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new NumbersFragment();
        } else if (position == 1){
            return new ColorsFragment();
        } else if (position == 2) {
            return new FamilyFragment();
        } else if (position == 3) {
            return new PhrasesFragment();
        } else {
            return new NumbersFragment();
        }
    }
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }

    @Override
    public int getCount() {
        return NUM_OF_TABS;
    }
}
