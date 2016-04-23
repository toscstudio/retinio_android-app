package com.retinio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.retinio.adapters.ReviewsAdapter;
import com.retinio.adapters.StoreAdapter;
import com.retinio.api.RetinioDataApi;
import com.retinio.fragments.StorePhotoFragment;
import com.retinio.pojo.Reviews;
import com.retinio.ui.InkPageIndicator;
import com.retinio.ui.SpacesItemDecoration;

import net.i2p.android.ext.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by naman on 03/04/16.
 */

public class StoreDetailActivity extends AppCompatActivity {

    InkPageIndicator pageIndicator;
    FloatingActionButton fabBookApointment, fabWriteReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        assert getSupportActionBar() != null;
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ViewPager viewPager = (ViewPager) findViewById(R.id.store_photo_viewpager);
        if (viewPager != null) {
            setupViewPager(viewPager);
            viewPager.setOffscreenPageLimit(2);
        }

        pageIndicator = (InkPageIndicator) findViewById(R.id.indicator);
        assert pageIndicator != null;
        pageIndicator.setViewPager(viewPager);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.reviews_list);
        List<Reviews> reviewsList = RetinioDataApi.getReviews();
        ReviewsAdapter adapter = new ReviewsAdapter(this, reviewsList);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addItemDecoration(new SpacesItemDecoration(40));
        fabBookApointment = (FloatingActionButton) findViewById(R.id.fab_book_appointment);
        fabWriteReview = (FloatingActionButton) findViewById(R.id.fab_write_review);

        fabBookApointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookAppointment();
            }
        });

        fabWriteReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeReview();
            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(StorePhotoFragment.newInstance("", 0), "");
        adapter.addFragment(StorePhotoFragment.newInstance("", 1), "");
        adapter.addFragment(StorePhotoFragment.newInstance("", 2), "");
        adapter.addFragment(StorePhotoFragment.newInstance("", 3), "");

        viewPager.setAdapter(adapter);
    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_store_detail, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                break;
            case R.id.action_book_appointment:
                bookAppointment();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void bookAppointment() {
        startActivity(new Intent(StoreDetailActivity.this, BookAppointmentActivity.class));
    }

    private void writeReview() {
        startActivity(new Intent(StoreDetailActivity.this, WriteReviewActivity.class));
    }
}
