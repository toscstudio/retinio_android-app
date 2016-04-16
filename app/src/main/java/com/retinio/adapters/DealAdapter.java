package com.retinio.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.retinio.R;
import com.retinio.pojo.Deal;

import java.util.List;

/**
 * Created by prempal on 13/4/16.
 */
public class DealAdapter extends RecyclerView.Adapter<DealAdapter.ViewHolder> {

    List<Deal> deals;
    Context context;

    public DealAdapter(List<Deal> deals, Context context) {
        this.deals = deals;
        this.context = context;
    }

    @Override
    public DealAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_deal, parent, false);
        return new ViewHolder(view);
    }



    @Override
    public int getItemCount() {
        return deals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView dealImage;
        TextView dealName, dealDesc, storeName;

        public ViewHolder(View itemView) {
            super(itemView);
            dealImage = (ImageView) itemView.findViewById(R.id.image_deal);
            dealName = (TextView) itemView.findViewById(R.id.text_deal_name);
            dealDesc = (TextView) itemView.findViewById(R.id.text_deal_desc);
            storeName = (TextView) itemView.findViewById(R.id.text_deal_store_name);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.dealName.setText(deals.get(position).getName());
        holder.dealDesc.setText(deals.get(position).getDesc());
        holder.storeName.setText(deals.get(position).getStoreName());
        switch (deals.get(position).getDealType()) {
            case CHECKUP:
                holder.dealImage.setImageResource(R.drawable.lineicon_eye_chart);
                break;
            case EYEWEAR:
            default:
                holder.dealImage.setImageResource(R.drawable.lineicon_sunglass_1);
                break;
        }
    }
}
