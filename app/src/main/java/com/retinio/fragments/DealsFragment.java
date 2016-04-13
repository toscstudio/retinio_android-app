package com.retinio.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.retinio.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DealsFragment extends Fragment {

    public static DealsFragment newInstance() {

        Bundle args = new Bundle();

        DealsFragment fragment = new DealsFragment();
        fragment.setArguments(args);
        return fragment;
    }


    public DealsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_deals, container, false);
    }

}
