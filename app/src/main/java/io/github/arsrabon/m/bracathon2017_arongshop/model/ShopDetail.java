package io.github.arsrabon.m.bracathon2017_arongshop.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by msrabon on 2/11/17.
 */

public class ShopDetail {
    private String key;
    private String shopName;
    private String address;
    private double latitude;
    private double longiude;
    private boolean visited;

    public ShopDetail() {
    }

    public ShopDetail(String shopName, String address, double latitude, double longiude, boolean visited) {
        this.shopName = shopName;
        this.address = address;
        this.latitude = latitude;
        this.longiude = longiude;
        this.visited = visited;
        try {
            this.key = generateMD5Key(this.shopName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongiude() {
        return longiude;
    }

    public void setLongiude(double longiude) {
        this.longiude = longiude;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public String generateMD5Key(String shopName) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(shopName.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }
}
