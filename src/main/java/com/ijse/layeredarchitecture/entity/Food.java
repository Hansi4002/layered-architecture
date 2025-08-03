package com.ijse.layeredarchitecture.entity;

public class Food {
    private String menuId;
    private String available;
    private String category;
    private double price;
    private String itemName;
    private String description;

    public Food(String menuId, String available, String category, double price, String itemName, String description) {
        this.menuId = menuId;
        this.available = available;
        this.category = category;
        this.price = price;
        this.itemName = itemName;
        this.description = description;
    }

    public String getMenuId() {return menuId;}

    public void setMenuId(String menuId) {this.menuId = menuId;}

    public String getAvailable() {return available;}

    public void setAvailable(String available) {this.available = available;}

    public String getCategory() {return category;}

    public void setCategory(String category) {this.category = category;}

    public double getPrice() {return price;}

    public void setPrice(double price) {this.price = price;}

    public String getItemName() {return itemName;}

    public void setItemName(String itemName) {this.itemName = itemName;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}
}
