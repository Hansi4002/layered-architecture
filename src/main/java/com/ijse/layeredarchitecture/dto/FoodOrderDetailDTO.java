package com.ijse.layeredarchitecture.dto;

public class FoodOrderDetailDTO {
    private String menuId;
    private String orderId;
    private double price;
    private int quantity;

    public FoodOrderDetailDTO(String menuId, String orderId, double price, int quantity) {
        this.menuId = menuId;
        this.orderId = orderId;
        this.price = price;
        this.quantity = quantity;
    }

    public String getMenuId() {return menuId;}

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "FoodOrderDetailDTO{" +
                "menuId='" + menuId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
