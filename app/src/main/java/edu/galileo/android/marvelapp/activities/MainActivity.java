package edu.galileo.android.marvelapp.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import edu.galileo.android.marvelapp.R;
import edu.galileo.android.marvelapp.adapter.SlidePagerAdapter;
import edu.galileo.android.marvelapp.fragments.EntireFragment;
import edu.galileo.android.marvelapp.fragments.MapaFragment;

public class MainActivity extends FragmentActivity {
    private final static String TAG = "MainActivity";
    private ViewPager pager;
    private PagerAdapter pagerAdapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        TabLayout tablay = (TabLayout) findViewById(R.id.tab_layout);
        tablay.addTab(tablay.newTab().setText("Principal"));
        tablay.addTab(tablay.newTab().setText("Mapa"));
        tablay.setTabGravity(TabLayout.GRAVITY_FILL);

        List<Fragment> fragments = getFragments();

        pager = (ViewPager) findViewById(R.id.pager);
        pagerAdapt = new SlidePagerAdapter(getSupportFragmentManager(), fragments);
        pager.setAdapter(pagerAdapt);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablay));
        tablay.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private List<Fragment> getFragments() {
        List<Fragment> fList = new ArrayList<>();

        fList.add(new EntireFragment());
        fList.add(new MapaFragment());
        return fList;
    }
}
