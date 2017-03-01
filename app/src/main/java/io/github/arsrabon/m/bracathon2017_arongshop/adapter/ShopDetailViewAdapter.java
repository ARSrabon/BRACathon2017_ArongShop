package io.github.arsrabon.m.bracathon2017_arongshop.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.textservice.TextInfo;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.StringTokenizer;

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
        holder.lbl_shopOwnerName.setText(shopDetail.getKey());
        holder.lbl_shopAddress.setText(shopDetail.getAddress());
        holder.lbl_shopPosition.setText(String.valueOf(position + 1));

        holder.btn_visitShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, ShopDetailsView_Activity.class);
                intent.putExtra("Shopkey",shopDetail.getKey());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return shopDetailList.size();
    }

    public static class ShopDetailViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        TextView lbl_shopName;
        TextView lbl_shopOwnerName;
        TextView lbl_shopAddress;
        TextView lbl_shopPosition;
        Button btn_visitShop;

        public ShopDetailViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cardview_ShopDetails);
            lbl_shopName = (TextView) itemView.findViewById(R.id.lbl_ShopName);
            lbl_shopOwnerName = (TextView) itemView.findViewById(R.id.lbl_ShopOwnerName);
            lbl_shopAddress = (TextView) itemView.findViewById(R.id.lbl_ShopAddress);
            lbl_shopPosition = (TextView) itemView.findViewById(R.id.lbl_position);
            btn_visitShop = (Button) itemView.findViewById(R.id.btn_visitShop);
        }
    }
}
