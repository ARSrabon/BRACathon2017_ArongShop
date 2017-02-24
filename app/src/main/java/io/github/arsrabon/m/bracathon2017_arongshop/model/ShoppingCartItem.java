package io.github.arsrabon.m.bracathon2017_arongshop.model;

/**
 * Created by msrabon on 2/15/17.
 */

public class ShoppingCartItem {
    private Product product;

    private int quantity;

    private double price;

    private double discount;

    public ShoppingCartItem() {
        super();
    }

    public ShoppingCartItem(Product product, int quantity, double discount) {
        super();
        this.product = product;
        this.quantity = quantity;
        this.discount = discount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        ///Updating the total price on changing of Quantity.
        setPrice((quantity*product.getPrice())*(1-(discount/100)));
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
