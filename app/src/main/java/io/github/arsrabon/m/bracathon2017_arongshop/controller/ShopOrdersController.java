package io.github.arsrabon.m.bracathon2017_arongshop.controller;

import java.util.ArrayList;
import java.util.List;

import io.github.arsrabon.m.bracathon2017_arongshop.model.ShoppingCart;
import io.github.arsrabon.m.bracathon2017_arongshop.model.ShoppingCartItem;

/**
 * Created by msrabon on 3/1/17.
 */
public class ShopOrdersController {
    /**
     *
     */
    private static ShopOrdersController ourInstance = new ShopOrdersController();

    private List<ShoppingCartItem> cartItems;
    private ShoppingCart shoppingCart;

    public static ShopOrdersController getInstance() {
        return ourInstance;
    }

    /**
     * This method will create new object for cartitems and shoppingcart.
     */
    public void initialize() {
        cartItems = new ArrayList<>();
        shoppingCart = new ShoppingCart();
    }

    public void addToCart(ShoppingCartItem item) {
        cartItems.add(item);
    }

    public void removeFromCart(ShoppingCartItem item) {
        cartItems.remove(item);
    }

    public ShoppingCartItem findItemFromCart(String searchKey, String searchSkuKey) {
        for (ShoppingCartItem cartItem : cartItems) {
            if (cartItem.getProduct().getpName().equals(searchKey) && cartItem.getProduct().getSku().equals(searchSkuKey)) {
                return cartItem;
            }
        }
        return null;
    }

    /**
     * This method will return shopingCart object after storing OrderItems.
     *
     * @return
     */
    public ShoppingCart confirmOrders() {
        shoppingCart.setCartItems(cartItems);
        return this.shoppingCart;
    }

    public void destroyAllData() {
        cartItems.clear();
        shoppingCart = null;
    }

    public List<ShoppingCartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<ShoppingCartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    private ShopOrdersController() {
    }
}
