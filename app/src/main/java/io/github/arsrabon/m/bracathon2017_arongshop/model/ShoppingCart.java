package io.github.arsrabon.m.bracathon2017_arongshop.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by msrabon on 2/15/17.
 */

public class ShoppingCart {
    private List<ShoppingCartItem> cartItems = new ArrayList<>();

    public ShoppingCart() {
    }

    public ShoppingCart(List<ShoppingCartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public List<ShoppingCartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<ShoppingCartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public void addToCart(ShoppingCartItem cartItem) {
        cartItems.add(cartItem);
    }

    public void removeFromCart(ShoppingCartItem cartItem) {
        cartItems.remove(cartItem);
    }

    public ShoppingCartItem getFromCart(ShoppingCartItem cartItem) {
        for (int i = 0; i < cartItems.size(); i++) {
            if (cartItems.get(i) == cartItem) {
                return cartItems.get(i);
            }
        }
        return null;
    }
}
