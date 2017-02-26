package io.github.arsrabon.m.bracathon2017_arongshop.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by msrabon on 2/11/17.
 */

public class ShopDetail {
    private String key;
    private String shopName;
    private String shopOwnerName;
    private String contact_1;
    private String contact_2;
    private String address;
    private String shopType;
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

    public ShopDetail(String shopName, String address, String shopType, double latitude, double longiude) {
        this.shopName = shopName;
        this.address = address;
        this.shopType = shopType;
        this.latitude = latitude;
        this.longiude = longiude;
        this.visited = false;
        try {
            this.key = generateMD5Key(this.shopName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ShopDetail(String shopName, String shopOwnerName, String address, String shopType, double latitude, double longiude) {
        this.shopName = shopName;
        this.shopOwnerName = shopOwnerName;
        this.address = address;
        this.shopType = shopType;
        this.latitude = latitude;
        this.longiude = longiude;
        this.visited = false;
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

    public String getShopOwnerName() {
        return shopOwnerName;
    }

    public void setShopOwnerName(String shopOwnerName) {
        this.shopOwnerName = shopOwnerName;
    }

    public String getShopType() {
        return shopType;
    }

    public void setShopType(String shopType) {
        this.shopType = shopType;
    }

    public String getContact_1() {
        return contact_1;
    }

    public void setContact_1(String contact_1) {
        this.contact_1 = contact_1;
    }

    public String getContact_2() {
        return contact_2;
    }

    public void setContact_2(String contact_2) {
        this.contact_2 = contact_2;
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
