package io.github.arsrabon.m.bracathon2017_arongshop.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import io.github.arsrabon.m.bracathon2017_arongshop.model.ShoppingCart;

/**
 * Created by msrabon on 3/1/17.
 */

public class ShopOrederHistoryAdapter extends RecyclerView.Adapter<ShopOrederHistoryAdapter.ShopOrederHistoryViewHolder> {

    private List<ShoppingCart> shoppingCarts;
    private Context context;
    private Activity activity;

    public ShopOrederHistoryAdapter(List<ShoppingCart> shoppingCarts, Context context, Activity activity) {
        this.shoppingCarts = shoppingCarts;
        this.context = context;
        this.activity = activity;
    }

    @Override
    public ShopOrederHistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ShopOrederHistoryViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return shoppingCarts.size();
    }

    public static class ShopOrederHistoryViewHolder extends RecyclerView.ViewHolder {

        public ShopOrederHistoryViewHolder(View itemView) {
            super(itemView);
        }
    }
}
