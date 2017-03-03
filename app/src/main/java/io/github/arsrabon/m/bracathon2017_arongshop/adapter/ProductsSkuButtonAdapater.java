package io.github.arsrabon.m.bracathon2017_arongshop.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import io.github.arsrabon.m.bracathon2017_arongshop.model.Product;

/**
 * Created by msrabon on 3/4/17.
 */

public class ProductsSkuButtonAdapater extends RecyclerView.Adapter<ProductsSkuButtonAdapater.ProductsSkuButtonViewHolder> {


    List<Product> products;
    Context context;
    Activity activity;

    public ProductsSkuButtonAdapater(List<Product> products, Context context) {
        this.products = products;
        this.context = context;
        this.activity = (Activity) context;
    }


    @Override
    public ProductsSkuButtonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ProductsSkuButtonViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class ProductsSkuButtonViewHolder extends RecyclerView.ViewHolder{

        public ProductsSkuButtonViewHolder(View itemView) {
            super(itemView);
        }
    }
}
