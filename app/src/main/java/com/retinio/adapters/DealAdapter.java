package com.retinio.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.retinio.R;

/**
 * Created by prempal on 13/4/16.
 */
public class DealAdapter extends RecyclerView.Adapter<DealAdapter.ViewHolder> {

    @Override
    public DealAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_deal, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DealAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView dealImage;

        public ViewHolder(View itemView) {
            super(itemView);
            dealImage = (ImageView) itemView.findViewById(R.id.iv_deal);
        }
    }
}
