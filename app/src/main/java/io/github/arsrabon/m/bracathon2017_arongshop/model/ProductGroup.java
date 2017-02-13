package io.github.arsrabon.m.bracathon2017_arongshop.model;

import java.util.List;

/**
 * Created by msrabon on 2/13/17.
 */

public class ProductGroup {
    private String name;
    private String info;
    private List<Product> products;

    public ProductGroup(String name, String info, List<Product> products) {
        this.name = name;
        this.info = info;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void addToProduct(Product product){
        products.add(product);
    }

    public void deleteProduct(Product product){
        products.remove(product);
    }
}
