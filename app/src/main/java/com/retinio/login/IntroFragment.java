package com.retinio.login;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.retinio.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class IntroFragment extends Fragment {


    public static IntroFragment newInstance(int position) {
        IntroFragment fragment = new IntroFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        fragment.setArguments(args);
        return fragment;
    }

    public IntroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_intro, container, false);

        TextView text = (TextView) rootView.findViewById(R.id.intro_text);

        switch (getArguments().getInt("position")) {
            case 0:
                text.setText("Discover optical stores and eye clinics near you");
                break;
            case 1:
                text.setText("Book appointments for your next eye checkup");
                break;
            case 2:
                text.setText("Look for the store with your favourite eyewear brand");
                break;
            case 3:
                text.setText("Browse through best offers in optical stores near you");
                break;
            default:
                break;
        }
        return rootView;

    }


}
