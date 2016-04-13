package com.retinio.adapters;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.retinio.R;
import com.retinio.StoreDetailActivity;
import com.retinio.pojo.Store;

import java.util.List;

/**
 * Created by prempal on 30/3/16.
 */
public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder> {

    List<Store> storesList;
    Activity context;

    public StoreAdapter(Activity context, List<Store> storesList) {
        this.storesList = storesList;
        this.context = context;
    }

    @Override
    public StoreAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_store, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StoreAdapter.ViewHolder holder, int position) {
        holder.storeName.setText(storesList.get(position).getName());
        holder.storeAddress.setText(storesList.get(position).getAddress());
        holder.docAvailable.setVisibility(View.GONE);
        holder.buyAvailable.setVisibility(View.GONE);
        if (storesList.get(position).isBuyAvailable())
            holder.buyAvailable.setVisibility(View.VISIBLE);
        if (storesList.get(position).isDocAvailable())
            holder.docAvailable.setVisibility(View.VISIBLE);

    }

    @Override
    public int getItemCount() {
        return storesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView storeName;
        TextView storeAddress;
        TextView storeDistance;
        TextView storeRating;
        ImageView storeLocation;
        ImageView storePhoto;
        ImageView docAvailable;
        ImageView buyAvailable;

        public ViewHolder(final View itemView) {
            super(itemView);

            storeName = (TextView) itemView.findViewById(R.id.store_name);
            storeAddress = (TextView) itemView.findViewById(R.id.store_address);
            storeDistance = (TextView) itemView.findViewById(R.id.store_distance);
            storeLocation = (ImageView) itemView.findViewById(R.id.store_location);
            storeRating = (TextView) itemView.findViewById(R.id.store_rating);
            storePhoto = (ImageView) itemView.findViewById(R.id.store_photo);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                storePhoto.setTransitionName("store_photo");
            }
            docAvailable = (ImageView) itemView.findViewById(R.id.store_doc_available);
            buyAvailable = (ImageView) itemView.findViewById(R.id.store_buy_available);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, StoreDetailActivity.class);
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation(context, storePhoto, "store_photo");
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        context.startActivity(intent, options.toBundle());
                    }
                }
            });

        }
    }
}
