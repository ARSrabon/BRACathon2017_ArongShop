package io.github.arsrabon.m.bracathon2017_arongshop.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import io.github.arsrabon.m.bracathon2017_arongshop.R;
import io.github.arsrabon.m.bracathon2017_arongshop.controller.ShoppingCartController;
import io.github.arsrabon.m.bracathon2017_arongshop.model.ActionBarBadgeCountUpdater;
import io.github.arsrabon.m.bracathon2017_arongshop.model.ShoppingCartItem;

/**
 * Created by msrabon on 2/19/17.
 */

public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.ShoppingCartViewHolder> {

    List<ShoppingCartItem> cartItems;
    Context context;
    Activity activity;

    ShoppingCartController cartController = ShoppingCartController.getInstance();
    private ActionBarBadgeCountUpdater countUpdater = ActionBarBadgeCountUpdater.getInstance();

    public ShoppingCartAdapter(Context context) {
        this.context = context;
        this.activity = (Activity) context;
        cartItems = cartController.getShoppingCart().getCartItems();
    }

    @Override
    public ShoppingCartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_confirmshoporder, parent, false);
        ShoppingCartAdapter.ShoppingCartViewHolder viewHolder = new ShoppingCartViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ShoppingCartViewHolder holder, int position) {
        final ShoppingCartItem item = cartItems.get(position);

        holder.productGroupName.setText(item.getProduct().getpName());
        holder.productSKU.setText(item.getProduct().getSku());
        holder.productPrice.setText(Double.toString(item.getPrice()));
        holder.edit_productQuantity.setText(String.valueOf(item.getQuantity()));

        holder.btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int qty = 0;
                if (!holder.edit_productQuantity.getText().toString().equals("")) {
                    qty = Integer.valueOf(holder.edit_productQuantity.getText().toString());
                }
                qty++;
                if (holder.pFlag) {
                    holder.pFlag = false;
                    countUpdater.setCount(countUpdater.getCount() + 1);
                    countUpdater.updateItemCount();
                    item.setQuantity(qty);
                    cartController.getShoppingCart().addToCart(item);
                }
                cartController.getShoppingCart().getFromCart(item).setQuantity(qty);
                holder.edit_productQuantity.setText(String.valueOf(qty));
            }
        });

        holder.btn_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int qts;
                if (!holder.edit_productQuantity.getText().toString().equals("")) {
                    qts = Integer.valueOf(holder.edit_productQuantity.getText().toString());
                } else {
                    qts = 0;
                }

                if (qts >= 1) {
                    qts--;
                }
                if (!holder.pFlag && qts == 0) {
                    holder.pFlag = false;
                    countUpdater.setCount(countUpdater.getCount() - 1);
                    countUpdater.updateItemCount();
                    item.setQuantity(qts);
                    cartController.getShoppingCart().removeFromCart(item);
                }
                cartController.getShoppingCart().getFromCart(item).setQuantity(qts);
                holder.edit_productQuantity.setText(String.valueOf(qts));
            }
        });
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public static class ShoppingCartViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView productGroupName;
        TextView productPrice;
        TextView productSKU;
        EditText edit_productQuantity;

        Button btn_add;
        Button btn_remove;
        public boolean pFlag = true;

        public ShoppingCartViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cardview_ShopOrders);
            productGroupName = (TextView) itemView.findViewById(R.id.lbl_productname);
            productSKU = (TextView) itemView.findViewById(R.id.lbl_productSKU);
            productPrice = (TextView) itemView.findViewById(R.id.lbl_productTotalPrice);

            edit_productQuantity = (EditText) itemView.findViewById(R.id.edt_productQuantity);

            btn_add = (Button) itemView.findViewById(R.id.btn_addQuantity);
            btn_remove = (Button) itemView.findViewById(R.id.btn_remove_Quantity);
        }
    }
}
