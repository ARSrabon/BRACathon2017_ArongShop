package io.github.arsrabon.m.bracathon2017_arongshop.model;

import java.util.List;

/**
 * Created by msrabon on 2/13/17.
 */

public class ProductGroup {
    private String pName;
    private String pNameBng;

    private String info;
    private String infoBng;

    private String imgLocation;

    private List<Product> products;

    public ProductGroup() {
        super();
    }

    public ProductGroup(String pName, String pNameBng, String info, String infoBng, String imgLocation, List<Product> products) {
        this.pName = pName;
        this.pNameBng = pNameBng;
        this.info = info;
        this.infoBng = infoBng;
        this.imgLocation = imgLocation;
        this.products = products;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpNameBng() {
        return pNameBng;
    }

    public void setpNameBng(String pNameBng) {
        this.pNameBng = pNameBng;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfoBng() {
        return infoBng;
    }

    public void setInfoBng(String infoBng) {
        this.infoBng = infoBng;
    }

    public String getImgLocation() {
        return imgLocation;
    }

    public void setImgLocation(String imgLocation) {
        this.imgLocation = imgLocation;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
