package com.example.nyt;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nyt.Fragment.Fragment;
import com.example.nyt.Fragment.Sayfa1;
import com.example.nyt.Fragment.Sayfa2;

public class MainActivity extends AppCompatActivity {

    private Fragment fragment;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment = new Fragment(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

    private void setupViewPager(ViewPager viewPager){
        Fragment adapter = new Fragment(getSupportFragmentManager());
        adapter.addFragment(new Sayfa1(), "Movies");
        adapter.addFragment(new Sayfa2(), "Top Stories");
        viewPager.setAdapter(adapter);
    }

}
