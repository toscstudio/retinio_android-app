package com.retinio.login;

import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.github.hmallet.realparallaxandroid.RealHorizontalScrollView;
import com.github.hmallet.realparallaxandroid.RealViewPager;
import com.retinio.R;
import com.retinio.ui.InkPageIndicator;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {

    Button skipButton;
    AnimationDrawable glassAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        skipButton = (Button) findViewById(R.id.btn_skip);
        if (findViewById(R.id.intro_glass_animator) != null) {
            glassAnim = (AnimationDrawable) ((ImageView) findViewById(R.id.intro_glass_animator)).getDrawable();
        }
        glassAnim.start();

        RealHorizontalScrollView realHorizontalScrollView = (RealHorizontalScrollView) findViewById(R.id.main_horizontal_scrollview);
        final RealViewPager realViewPager = (RealViewPager) findViewById(R.id.main_view_pager);

        List<Fragment> fragments = new ArrayList<>();

        //TODO : Define the '4' in some variable.
        for (int i = 0; i < 4; i++) {
            fragments.add(IntroFragment.newInstance(i));
        }

        Display display = getWindowManager().getDefaultDisplay();
        final Point size = new Point();
        display.getSize(size);

        PagerAdapter realViewPagerAdapter = new IntroPagerAdapter(getSupportFragmentManager(), fragments);

        assert realViewPager != null;
        realViewPager.setAdapter(realViewPagerAdapter);
        realViewPager.configure(realHorizontalScrollView);

        realViewPager.addOnPageChangeListener(new LastPageSkipListener());

        InkPageIndicator pageIndicator = (InkPageIndicator) findViewById(R.id.indicator);
        if (pageIndicator != null)
            pageIndicator.setViewPager(realViewPager);

        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnboardHelper.setIntroDone();
                Intent loginActIntent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(loginActIntent);
                finish();
            }
        });

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

    private class LastPageSkipListener extends ViewPager.SimpleOnPageChangeListener {
        @Override
        public void onPageSelected(int position) {
            //TODO: Do not hardcode 3, find what is last page in code
            if (position == 3) {
                skipButton.setText(">");
            } else {
                skipButton.setText(R.string.intro_skip);
            }
            super.onPageSelected(position);
        }
    }
}
