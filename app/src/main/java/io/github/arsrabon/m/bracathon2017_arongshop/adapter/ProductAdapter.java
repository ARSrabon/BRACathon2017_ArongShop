package io.github.arsrabon.m.bracathon2017_arongshop.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.github.arsrabon.m.bracathon2017_arongshop.R;
import io.github.arsrabon.m.bracathon2017_arongshop.model.Product;

/**
 * Created by msrabon on 2/13/17.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> productLists;

    public ProductAdapter(ArrayList<Product> productLists) {
        this.productLists = productLists;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
//        ProductViewHolder viewHolder = new ProductViewHolder(v);
//        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, final int position) {
//        holder.product_Name.setText("Name: " + productLists.get(position).getProductName());
//        holder.product_Stock.setText("Stock: " + productLists.get(position).getProductStock());
////        Log.d("Product Adapter",productLists.get(position).getProductName());
//
//        holder.cv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("Product_Adapter_OnClick",productLists.get(position).getProductName());
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return productLists.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView product_Name;
        TextView product_Stock;

        public ProductViewHolder(View itemView) {
            super(itemView);
//            cv = (CardView) itemView.findViewById(R.id.cv);
//            product_Name = (TextView) itemView.findViewById(R.id.product_name);
//            product_Stock = (TextView) itemView.findViewById(R.id.product_stock);
        }
    }

}
