package com.retinio.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.retinio.MainActivity;
import com.retinio.R;
import com.retinio.adapters.StoreAdapter;
import com.retinio.pojo.Store;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ExploreFragment extends Fragment {

    private RecyclerView mRecyclerView;

    public ExploreFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_explore, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.store_list);
        mRecyclerView.setAdapter(new StoreAdapter(createRandomList()));
        return rootView;
    }

    private List<Store> createRandomList() {
        List<Store> storeList = new ArrayList<>();
        for (int i = 10; i > 0; i--) {
            Store s = new Store();
            s.setName("Eye Trends");
            s.setAddress("B-1/113, Rohini, New Delhi");
            s.setBuyAvailable(true);
            s.setDocAvailable(true);
            s.setOfferAvailable(true);
            storeList.add(s);
        }
        return storeList;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_explore_maptoggle, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_toggle_map:
                ((MainActivity)getActivity()).transactFragment(new ExploreMapFragment());
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
