package io.github.arsrabon.m.bracathon2017_arongshop.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import io.github.arsrabon.m.bracathon2017_arongshop.R;
import io.github.arsrabon.m.bracathon2017_arongshop.controller.ActionBarBadgeCountUpdater;
import io.github.arsrabon.m.bracathon2017_arongshop.model.Product;
import io.github.arsrabon.m.bracathon2017_arongshop.model.ShoppingCartItem;

/**
 * Created by msrabon on 2/13/17.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> productLists;
    private Context context;
    private Activity activity;

    ActionBarBadgeCountUpdater countUpdater = ActionBarBadgeCountUpdater.getInstance();

    public ProductAdapter(List<Product> productLists, Context context) {
        this.productLists = productLists;
        this.context = context;
        this.activity = (Activity) context;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_product_sku, parent, false);
        ProductViewHolder viewHolder = new ProductViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, final int position) {
        final Product product = productLists.get(position);
        holder.product_SKU.setText(product.getSku());
        holder.productQuantity.setText(String.valueOf(product.getPrice()));
    }

    @Override
    public int getItemCount() {
        return productLists.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView product_SKU;
        TextView productQuantity;

        boolean pFlag = true;

        public ProductViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.productsku_cardview);
            product_SKU = (TextView) itemView.findViewById(R.id.lbl_productSKU);
            productQuantity = (TextView) itemView.findViewById(R.id.lbl_productSKUPrice);
        }
    }

}
