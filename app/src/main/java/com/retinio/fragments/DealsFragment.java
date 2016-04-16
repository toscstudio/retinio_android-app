package com.retinio.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.retinio.R;
import com.retinio.adapters.DealAdapter;
import com.retinio.api.RetinioDataApi;


/**
 * A simple {@link Fragment} subclass.
 */
public class DealsFragment extends Fragment {

    public DealsFragment() {
        // Required empty public constructor
    }

    public static DealsFragment newInstance() {
        Bundle args = new Bundle();
        DealsFragment fragment = new DealsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_deals, container, false);
        RecyclerView mRecyclerView = (RecyclerView) rootView.findViewById(R.id.deals_list);
        mRecyclerView.setAdapter(new DealAdapter(RetinioDataApi.getDeals(), getContext()));
        return rootView;
    }

}
