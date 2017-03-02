package io.github.arsrabon.m.bracathon2017_arongshop.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by msrabon on 2/15/17.
 */

public class ShoppingCart {

    private String date;
    private List<ShoppingCartItem> cartItems = new ArrayList<>();
    private double totalPrice;
    private int typeOfProduct;

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

    public ShoppingCartItem getFromCart(ShoppingCartItem cartItem) {
        for (int i = 0; i < cartItems.size(); i++) {
            if (cartItems.get(i) == cartItem) {
                return cartItems.get(i);
            }
        }
        return null;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotalPrice() {
        this.totalPrice = 0;
        for (ShoppingCartItem item : cartItems) {
            totalPrice = item.getPrice();
        }
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTypeOfProduct() {
        return typeOfProduct;
    }

    public void setTypeOfProduct(int typeOfProduct) {
        this.typeOfProduct = typeOfProduct;
    }
}
