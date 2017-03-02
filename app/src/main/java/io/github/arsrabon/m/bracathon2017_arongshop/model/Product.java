package io.github.arsrabon.m.bracathon2017_arongshop.model;



import java.lang.reflect.Modifier;

/**
 * Created by msrabon on 2/11/17.
 */
public class Product {

    private String pName;
    private String pBngName;

    private String sku;
    private String skuBng;

    private double price;
    private String priceBng;

    private String imgLocation;

    private boolean discount;

    public Product() {
    }

    public Product(String pName, String pBngName, String sku, String skuBng,
                   double price, String priceBng, String imgLocation, boolean discount) {
        this.pName = pName;
        this.pBngName = pBngName;
        this.sku = sku;
        this.skuBng = skuBng;
        this.price = price;
        this.priceBng = priceBng;
        this.imgLocation = imgLocation;
        this.discount = discount;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpBngName() {
        return pBngName;
    }

    public void setpBngName(String pBngName) {
        this.pBngName = pBngName;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getSkuBng() {
        return skuBng;
    }

    public void setSkuBng(String skuBng) {
        this.skuBng = skuBng;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPriceBng() {
        return priceBng;
    }

    public void setPriceBng(String priceBng) {
        this.priceBng = priceBng;
    }

    public String getImgLocation() {
        return imgLocation;
    }

    public void setImgLocation(String imgLocation) {
        this.imgLocation = imgLocation;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }
}
