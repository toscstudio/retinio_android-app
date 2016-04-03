package com.retinio;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.retinio.models.Store;

import java.util.List;

/**
 * Created by prempal on 30/3/16.
 */
public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder> {

    List<Store> storesList;

    public StoreAdapter(List<Store> storesList) {
        this.storesList = storesList;
    }

    @Override
    public StoreAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_store, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StoreAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
