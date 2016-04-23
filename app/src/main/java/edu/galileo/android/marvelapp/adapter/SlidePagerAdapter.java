package edu.galileo.android.marvelapp.adapter;

import android.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import edu.galileo.android.marvelapp.fragments.EntireFragment;

/**
 * Created by José P. Rodríguez on 17/04/2016.
 */
public class SlidePagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentos;

    public SlidePagerAdapter(android.support.v4.app.FragmentManager fm, List<Fragment> frags) {
        super(fm);
        this.fragmentos = frags;
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragmentos.get(position);
    }

    @Override
    public int getCount() {
        return this.fragmentos.size();
    }
}
