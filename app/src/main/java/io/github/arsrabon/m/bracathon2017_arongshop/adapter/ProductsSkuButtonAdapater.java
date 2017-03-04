package io.github.arsrabon.m.bracathon2017_arongshop.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import io.github.arsrabon.m.bracathon2017_arongshop.R;
import io.github.arsrabon.m.bracathon2017_arongshop.controller.ShopOrdersController;
import io.github.arsrabon.m.bracathon2017_arongshop.model.Product;
import io.github.arsrabon.m.bracathon2017_arongshop.model.ShoppingCartItem;

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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_skubuttons, parent, false);
        ProductsSkuButtonViewHolder viewHolder = new ProductsSkuButtonViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ProductsSkuButtonViewHolder holder, final int position) {
        holder.btn_sku.setText(products.get(position).getSku());

        holder.btn_sku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ShopOrdersController controller = ShopOrdersController.getInstance();
                TextView view = (TextView) activity.findViewById(R.id.lbl_productSKUinfo);
                view.setText(products.get(position).getSku() + " - " + products.get(position).getPrice());
                TextView view1 = (TextView) activity.findViewById(R.id.lbl_showDiscount);
                if (products.get(position).isDiscount()) {
                    view1.setText("মূল্যহ্রাস: ০ টাকা");
                } else {
                    view1.setVisibility(View.INVISIBLE);
                }
                ImageButton btn_plus = (ImageButton) activity.findViewById(R.id.btn_plus);
                ImageButton btn_minus = (ImageButton) activity.findViewById(R.id.btn_minus);
                final EditText editText = (EditText) activity.findViewById(R.id.edt_productQuantity);
                ShoppingCartItem item;
                btn_plus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String s = editText.getText().toString();
                        if (!s.equals(null) && !s.equals("")) {
                            int x = Integer.valueOf(s);
                            if (x >= 0) {
                                x++;
                                editText.setText(String.valueOf(x));
                            }
                        } else {
                            editText.setText("1");
                        }
                    }
                });

                btn_minus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String s = editText.getText().toString();
                        if (!s.equals(null) && !s.equals("")) {
                            int x = Integer.valueOf(s);
                            if (x > 0) {
                                x--;
                                editText.setText(String.valueOf(x));
                            }else {
                                x=0;
                                editText.setText(String.valueOf(x));
                            }
                        } else {
                            editText.setText("1");
                        }
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class ProductsSkuButtonViewHolder extends RecyclerView.ViewHolder {

        Button btn_sku;

        public ProductsSkuButtonViewHolder(View itemView) {
            super(itemView);
            btn_sku = (Button) itemView.findViewById(R.id.btn_SKU);
        }
    }
}
