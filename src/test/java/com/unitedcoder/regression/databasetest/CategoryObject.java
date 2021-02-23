package com.unitedcoder.regression.databasetest;

public class CategoryObject {
    private String cat_name, cat_desc;
    private int cat_parent_id, cat_image, per_ship, priority, status;
    private String seoMetaTitle, seoMetaDescription, seoMetaKeyword;

    public CategoryObject(String cat_name, String cat_desc, int cat_parent_id, int cat_image, int per_ship, int priority, int status, String seoMetaTitle, String seoMetaDescription, String seoMetaKeyword) {
        this.cat_name = cat_name;
        this.cat_desc = cat_desc;
        this.cat_parent_id = cat_parent_id;
        this.cat_image = cat_image;
        this.per_ship = per_ship;
        this.priority = priority;
        this.status = status;
        this.seoMetaTitle = seoMetaTitle;
        this.seoMetaDescription = seoMetaDescription;
        this.seoMetaKeyword = seoMetaKeyword;
    }

    public String getCat_name() {
        return cat_name;
    }

    public String getCat_desc() {
        return cat_desc;
    }

    public int getCat_parent_id() {
        return cat_parent_id;
    }

    public int getCat_image() {
        return cat_image;
    }

    public int getPer_ship() {
        return per_ship;
    }

    public int getPriority() {
        return priority;
    }

    public int getStatus() {
        return status;
    }

    public String getSeoMetaTitle() {
        return seoMetaTitle;
    }

    public String getSeoMetaDescription() {
        return seoMetaDescription;
    }

    public String getSeoMetaKeyword() {
        return seoMetaKeyword;
    }
}
