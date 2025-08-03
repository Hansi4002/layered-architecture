package com.ijse.layeredarchitecture.entity;

import java.sql.Date;

public class SupplierFood {
    private String menuId;
    private String supplierId;
    private double cost;
    private int quantity;
    private Date supplyDate;

    public SupplierFood(String menuId, String supplierId, double cost, int quantity, Date supplyDate) {
        this.menuId = menuId;
        this.supplierId = supplierId;
        this.cost = cost;
        this.quantity = quantity;
        this.supplyDate = supplyDate;
    }

    public String getMenuId() {return menuId;}

    public void setMenuId(String menuId) {this.menuId = menuId;}

    public String getSupplierId() {return supplierId;}

    public void setSupplierId(String supplierId) {this.supplierId = supplierId;}

    public double getCost() {return cost;}

    public void setCost(double cost) {this.cost = cost;}

    public int getQuantity() {return quantity;}

    public void setQuantity(int quantity) {this.quantity = quantity;}

    public Date getSupplyDate() {return supplyDate;}

    public void setSupplyDate(Date supplyDate) {this.supplyDate = supplyDate;}
}
