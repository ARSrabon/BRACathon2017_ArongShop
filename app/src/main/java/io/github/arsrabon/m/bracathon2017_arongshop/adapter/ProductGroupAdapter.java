package io.github.arsrabon.m.bracathon2017_arongshop.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import io.github.arsrabon.m.bracathon2017_arongshop.R;
import io.github.arsrabon.m.bracathon2017_arongshop.activity.ProcessProductOrder;
import io.github.arsrabon.m.bracathon2017_arongshop.model.ProductGroup;

/**
 * Created by msrabon on 2/13/17.
 */

public class ProductGroupAdapter extends RecyclerView.Adapter<ProductGroupAdapter.ProductGroupViewHolder> {

    List<ProductGroup> productGroups;
    Context context;
    Activity activity;

    public ProductGroupAdapter(List<ProductGroup> productGroups, Context context, Activity activity) {
        this.productGroups = productGroups;
        this.context = context;
        this.activity = activity;
    }

    public ProductGroupAdapter(List<ProductGroup> productGroups, Context context) {
        this.productGroups = productGroups;
        this.context = context;
        this.activity = (Activity) context;
    }

    @Override
    public ProductGroupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_productgroup, parent, false);
        ProductGroupViewHolder productGroupViewHolder = new ProductGroupViewHolder(view);
        return productGroupViewHolder;
    }

    @Override
    public void onBindViewHolder(final ProductGroupViewHolder holder, final int position) {
        final ProductGroup productGroup = productGroups.get(position);
//        Log.d("onBindViewHolder", String.valueOf(productGroup.getProducts().size()));
        holder.productName.setText(productGroups.get(position).getpName());
        String imgLoc = "R.drawable." + productGroups.get(position).getImgLocation();
        holder.product_view.setImageResource(Integer.parseInt(imgLoc));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProcessProductOrder.class);
                intent.putExtra("ProductName", productGroup.getpName().toString());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
//        return productGroups.size();
        Log.d("progroSize", "");
        return 0;
    }

    public static class ProductGroupViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView productName;
        ImageView product_view;

        public ProductGroupViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.productGroupCardView);
            productName = (TextView) itemView.findViewById(R.id.lbl_productGroupName);
            product_view = (ImageView) itemView.findViewById(R.id.img_product);
        }
    }
}