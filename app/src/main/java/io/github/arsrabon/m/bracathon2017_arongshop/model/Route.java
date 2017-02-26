package io.github.arsrabon.m.bracathon2017_arongshop.model;

import java.util.List;

/**
 * Created by msrabon on 2/26/17.
 */

public class Route {
    private String routeName;
    private List<ShopDetail> shopDetailList;

    public Route() {
    }

    public Route(String routeName, List<ShopDetail> shopDetailList) {
        this.routeName = routeName;
        this.shopDetailList = shopDetailList;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public List<ShopDetail> getShopDetailList() {
        return shopDetailList;
    }

    public void setShopDetailList(List<ShopDetail> shopDetailList) {
        this.shopDetailList = shopDetailList;
    }

    @Override
    public String toString() {
        return routeName;
    }
}
