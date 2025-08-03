package com.ijse.layeredarchitecture.view.tdm;

import java.sql.Date;

public class FoodOrderTM {
    private String orderId;
    private String reservationId;
    private String orderType;
    private String status;
    private double totalAmount;
    private Date orderDate;

    public FoodOrderTM(String orderId, String reservationId, String orderType, String status, double totalAmount, Date orderDate) {
        this.orderId = orderId;
        this.reservationId = reservationId;
        this.orderType = orderType;
        this.status = status;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
    }

    public String getOrderId() {return orderId;}

    public void setOrderId(String orderId) {this.orderId = orderId;}

    public String getReservationId() {return reservationId;}

    public void setReservationId(String reservationId) {this.reservationId = reservationId;}

    public String getOrderType() {return orderType;}

    public void setOrderType(String orderType) {this.orderType = orderType;}

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = status;}

    public double getTotalAmount() {return totalAmount;}

    public void setTotalAmount(double totalAmount) {this.totalAmount = totalAmount;}

    public Date getOrderDate() {return orderDate;}

    public void setOrderDate(Date orderDate) {this.orderDate = orderDate;}

    @Override
    public String toString() {
        return "FoodOrderDTO{" +
                "orderId='" + orderId + '\'' +
                ", reservationId='" + reservationId + '\'' +
                ", orderType='" + orderType + '\'' +
                ", status='" + status + '\'' +
                ", totalAmount=" + totalAmount +
                ", orderDate=" + orderDate +
                '}';
    }

    //compareTo
}
