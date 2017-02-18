package io.github.arsrabon.m.bracathon2017_arongshop.model;

/**
 * Created by msrabon on 2/11/17.
 */

public class Product {
    private String pName;
    private String sku;
    private double price;
    private double discount;

    public Product(String pName, String sku, double price) {
        this.pName = pName;
        this.sku = sku;
        this.price = price;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
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
