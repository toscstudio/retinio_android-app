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
import com.retinio.pojo.Reviews;

import java.util.List;

/**
 * Created by raghav on 23/04/16.
 */
public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.ViewHolder> {

    List<Reviews> reviewsList;
    Activity context;

    public ReviewsAdapter(Activity context, List<Reviews> reviewsList) {
        this.reviewsList = reviewsList;
        this.context = context;
    }

    @Override
    public ReviewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_reviews, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ReviewsAdapter.ViewHolder holder, int position) {
        holder.userName.setText(reviewsList.get(position).getName());
        holder.userReview.setText(reviewsList.get(position).getReview());

    }

    @Override
    public int getItemCount() {
        return reviewsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView userName;
        TextView userReview;
        TextView userRating;
        ImageView userPhoto;


        public ViewHolder(final View itemView) {
            super(itemView);

            userName = (TextView) itemView.findViewById(R.id.user_name);
            userReview = (TextView) itemView.findViewById(R.id.user_review);
            userRating = (TextView) itemView.findViewById(R.id.user_rating);
            userPhoto = (ImageView) itemView.findViewById(R.id.user_photo);

        }
    }
}
