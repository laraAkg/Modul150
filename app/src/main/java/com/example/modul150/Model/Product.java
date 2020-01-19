package com.example.modul150.Model;

public class Product {
    private int id;
    private String product;
    private String price;
    private String description;
    private boolean isSelected;

    public Product(int id, String product, String price, String description, boolean isSelected) {
        this.id = id;
        this.product = product;
        this.price = price;
        this.description = description;
        this.isSelected = isSelected;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getproduct() {
        return product;
    }

    public void setproduct(String product) {
        this.product = product;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }
}
