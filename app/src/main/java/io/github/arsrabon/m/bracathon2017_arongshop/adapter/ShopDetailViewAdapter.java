package io.github.arsrabon.m.bracathon2017_arongshop.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import io.github.arsrabon.m.bracathon2017_arongshop.R;
import io.github.arsrabon.m.bracathon2017_arongshop.activity.ShopDetailsView_Activity;
import io.github.arsrabon.m.bracathon2017_arongshop.model.ShopDetail;

/**
 * Created by msrabon on 2/26/17.
 */

public class ShopDetailViewAdapter extends RecyclerView.Adapter<ShopDetailViewAdapter.ShopDetailViewHolder> {

    List<ShopDetail> shopDetailList;
    Context context;
    Activity activity;

    public ShopDetailViewAdapter(List<ShopDetail> shopDetailList, Context context, String routeName) {
        this.shopDetailList = shopDetailList;
        this.context = context;
        this.activity = (Activity) context;
        this.routeName = routeName;
    }

    String routeName;

    public ShopDetailViewAdapter(List<ShopDetail> shopDetailList, Context context) {
        this.shopDetailList = shopDetailList;
        this.context = context;
        this.activity = (Activity) context;
    }

    @Override
    public ShopDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_shoplist, parent, false);
        ShopDetailViewHolder viewHolder = new ShopDetailViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ShopDetailViewHolder holder, int position) {
        final ShopDetail shopDetail = shopDetailList.get(position);

        holder.lbl_shopName.setText(shopDetail.getShopName());
        holder.lbl_shopAddress.setText(shopDetail.getAddress());
        holder.lbl_shopOwnerName.setVisibility(View.GONE);
        if (shopDetail.isVisited()) {
            holder.view.setImageResource(R.drawable.notepad_g);
        } else {
            holder.view.setImageResource(R.drawable.notepad_r);
        }
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, ShopDetailsView_Activity.class);
                intent.putExtra("routeName", routeName);
                intent.putExtra("ShopName", shopDetail.getKey());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return shopDetailList.size();
    }

    public static class ShopDetailViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView lbl_shopName;
        TextView lbl_shopOwnerName;
        TextView lbl_shopAddress;
        ImageView view;

        public ShopDetailViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cardview_ShopDetails);
            lbl_shopName = (TextView) itemView.findViewById(R.id.lbl_ShopName);
            lbl_shopOwnerName = (TextView) itemView.findViewById(R.id.lbl_ShopOwnerName);
            lbl_shopAddress = (TextView) itemView.findViewById(R.id.lbl_ShopAddress);
            view = (ImageView) itemView.findViewById(R.id.img_status);
        }
    }
}
