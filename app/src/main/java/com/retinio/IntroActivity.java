package com.retinio;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;

import com.github.hmallet.realparallaxandroid.RealHorizontalScrollView;
import com.github.hmallet.realparallaxandroid.RealViewPager;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        RealHorizontalScrollView realHorizontalScrollView = (RealHorizontalScrollView) findViewById(R.id.main_horizontal_scrollview);
        final RealViewPager realViewPager = (RealViewPager) findViewById(R.id.main_view_pager);

        List<Fragment> fragments = new ArrayList<>();

        fragments.add(new IntroFragment());
        fragments.add(new IntroFragment());
        fragments.add(new IntroFragment());

        Display display = getWindowManager().getDefaultDisplay();
        final Point size = new Point();
        display.getSize(size);

        PagerAdapter realViewPagerAdapter = new IntroPagerAdapter(getSupportFragmentManager(), fragments);

        assert realViewPager != null;
        realViewPager.setAdapter(realViewPagerAdapter);
        realViewPager.configure(realHorizontalScrollView);
    }

    private class IntroPagerAdapter extends FragmentPagerAdapter {

        private final List fragments;

        public IntroPagerAdapter(FragmentManager fm, List fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return (Fragment) this.fragments.get(position);
        }

        @Override
        public int getCount() {
            return this.fragments.size();
        }
    }
}
