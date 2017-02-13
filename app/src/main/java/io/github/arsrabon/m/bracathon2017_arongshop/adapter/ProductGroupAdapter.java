package io.github.arsrabon.m.bracathon2017_arongshop.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import io.github.arsrabon.m.bracathon2017_arongshop.R;
import io.github.arsrabon.m.bracathon2017_arongshop.model.ProductGroup;

/**
 * Created by msrabon on 2/13/17.
 */

public class ProductGroupAdapter extends RecyclerView.Adapter<ProductGroupAdapter.ProductGroupViewHolder> {

    List<ProductGroup> productGroups;
    Context context;

    public ProductGroupAdapter(List<ProductGroup> productGroups, Context context) {
        this.productGroups = productGroups;
        this.context = context;
    }

    @Override
    public ProductGroupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_productgroup,parent,false);
        ProductGroupViewHolder productGroupViewHolder = new ProductGroupViewHolder(view);
        return productGroupViewHolder;
    }

    @Override
    public void onBindViewHolder(final ProductGroupViewHolder holder, int position) {
        holder.productName.setText(productGroups.get(position).getName());
        holder.productInfo.setText(productGroups.get(position).getInfo());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.showDirection.setImageResource(R.drawable.ic_arrow_upward_black_24dp);
                holder.skuView.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productGroups.size();
    }

    public static class ProductGroupViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        TextView productName;
        TextView productInfo;
        ImageView product_view;
        ImageView showDirection;
        RecyclerView skuView;

        public ProductGroupViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.productGroupCardView);
            productName = (TextView) itemView.findViewById(R.id.lbl_productname);
            productInfo = (TextView) itemView.findViewById(R.id.lbl_productinfo);
            product_view = (ImageView) itemView.findViewById(R.id.img_product);
            showDirection = (ImageView) itemView.findViewById(R.id.img_showdirection);
            skuView = (RecyclerView) itemView.findViewById(R.id.showproducts);
            skuView.setVisibility(View.GONE);
        }
    }
}