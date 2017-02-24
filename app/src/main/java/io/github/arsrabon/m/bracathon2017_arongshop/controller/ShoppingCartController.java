package io.github.arsrabon.m.bracathon2017_arongshop.controller;

import java.util.ArrayList;
import java.util.List;

import io.github.arsrabon.m.bracathon2017_arongshop.model.ShoppingCart;

/**
 * Created by msrabon on 2/18/17.
 */
public class ShoppingCartController {
    private static ShoppingCartController ourInstance = new ShoppingCartController();

    List<ShoppingCart> shopOrders = new ArrayList<>();
    private ShoppingCart shoppingCart;

    public static ShoppingCartController getInstance() {
        return ourInstance;
    }

    private ShoppingCartController() {
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void newShoppingCart(){
        this.shoppingCart = new ShoppingCart();
    }

    public void destroyShoppingCart(){
        if(shoppingCart != null){
            this.shoppingCart = null;
        }
    }

    public void addToShopOrders(){
        shopOrders.add(this.shoppingCart);
    }
}
