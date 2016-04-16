package com.retinio;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by naman on 11/04/16.
 */
public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        if (viewPager != null) {
            setupViewPager(viewPager);
        }
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(new AccountFragment(), "Account");
        adapter.addFragment(new EyeDetailsFragment(), "Eye details");
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


    public class AccountFragment extends Fragment {

        TextView address, phone;
        ViewSwitcher addressSwitcher, phoneSwitcher;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_profile_account, container, false);

            address = (TextView) rootView.findViewById(R.id.text_address);
            phone = (TextView) rootView.findViewById(R.id.text_phone);

            addressSwitcher = (ViewSwitcher) rootView.findViewById(R.id.address_switcher);
            phoneSwitcher = (ViewSwitcher) rootView.findViewById(R.id.phone_switcher);

            address.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addressSwitcher.showNext();
                }
            });
            phone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    phoneSwitcher.showNext();
                }
            });

            return rootView;
        }
    }


    public class EyeDetailsFragment extends Fragment {

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_eye_detail, container, false);
            final EditText cylindricalRight = (EditText) rootView.findViewById(R.id.cylindrical_right);
            final EditText cylindricalLeft = (EditText) rootView.findViewById(R.id.cylindrical_left);
            final EditText axisRight = (EditText) rootView.findViewById(R.id.axis_right);
            final EditText axisLeft = (EditText) rootView.findViewById(R.id.axis_left);
            final EditText sphericalLeft = (EditText) rootView.findViewById(R.id.spherical_left);
            final EditText sphericalRight = (EditText) rootView.findViewById(R.id.spherical_right);
            ImageView spectacles = (ImageView) rootView.findViewById(R.id.specs);
            ImageView leftSpectacle  = (ImageView) rootView.findViewById(R.id.specs_left);
            ImageView rightSpectacle = (ImageView) rootView.findViewById(R.id.specs_right);
            final Button submitButton = (Button) rootView.findViewById(R.id.submit_button);

            submitButton.setVisibility(View.GONE);
            axisLeft.setEnabled(false);
            axisRight.setEnabled(false);
            cylindricalLeft.setEnabled(false);
            cylindricalRight.setEnabled(false);
            sphericalLeft.setEnabled(false);
            sphericalRight.setEnabled(false);

            leftSpectacle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    axisLeft.setEnabled(true);
                    cylindricalLeft.setEnabled(true);
                    sphericalLeft.setEnabled(true);
                    submitButton.setVisibility(View.VISIBLE);
                }
            });

            rightSpectacle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    axisRight.setEnabled(true);
                    cylindricalRight.setEnabled(true);
                    sphericalRight.setEnabled(true);
                    submitButton.setVisibility(View.VISIBLE);
                }
            });

            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    axisLeft.setEnabled(false);
                    axisRight.setEnabled(false);
                    cylindricalLeft.setEnabled(false);
                    cylindricalRight.setEnabled(false);
                    sphericalLeft.setEnabled(false);
                    sphericalRight.setEnabled(false);
                    submitButton.setVisibility(View.GONE);
                }
            });
            return rootView;
        }
    }
}
