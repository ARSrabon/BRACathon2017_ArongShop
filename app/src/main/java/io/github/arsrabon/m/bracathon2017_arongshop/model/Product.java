package io.github.arsrabon.m.bracathon2017_arongshop.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.lang.reflect.Modifier;

/**
 * Created by msrabon on 2/11/17.
 */
@Table(name = "products")
public class Product extends Model {
    @Column(name = "group_name")
    private String pName;

    @Column(name = "p_sku")
    private String sku;

    @Column(name = "p_price")
    private double price;

    @Column(name = "p_discount")
    private double discount;

    public Product() {
    }

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
