package com.onboarding.ecomm.Model.Response;


import com.google.gson.annotations.SerializedName;


public class Category {

    @SerializedName("name")
    private String name;

    @SerializedName("categoryId")
    private String categoryId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return
                "Category{" +
                        "name = '" + name + '\'' +
                        ",categoryId = '" + categoryId + '\'' +
                        "}";
    }
}