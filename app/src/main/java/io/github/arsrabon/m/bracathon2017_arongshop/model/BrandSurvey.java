package io.github.arsrabon.m.bracathon2017_arongshop.model;

/**
 * Created by msrabon on 3/4/17.
 */

public class BrandSurvey {
    String name;
    int img_id;

    public BrandSurvey(String name, int img_id) {
        this.name = name;
        this.img_id = img_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg_id() {
        return img_id;
    }

    public void setImg_id(int img_id) {
        this.img_id = img_id;
    }

    @Override
    public String toString() {
        return name;
    }
}
