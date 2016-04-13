package com.retinio.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.retinio.R;

/**
 * Created by naman on 03/04/16.
 */
public class StorePhotoFragment extends Fragment {

    int position;

    public static StorePhotoFragment newInstance(String uri, int position) {
        StorePhotoFragment fragment = new StorePhotoFragment();
        Bundle args = new Bundle();
        args.putString("image_uri", uri);
        args.putInt("position", position);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_viewpager_store_photo, container, false);

        ImageView imageView = (ImageView) rootView.findViewById(R.id.store_photo);
        position = getArguments().getInt("position");
        if (position == 0) {
            imageView.setTransitionName("store_photo");
        }

        //TODO load uri in imageView

        return rootView;
    }
}
