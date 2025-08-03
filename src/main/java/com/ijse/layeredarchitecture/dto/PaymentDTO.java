package com.ijse.layeredarchitecture.dto;

import java.time.LocalDate;

public class PaymentDTO {
    private String paymentId;
    private String reservationId;
    private LocalDate paymentDate;
    private double totalCost;
    private String transactionId;
    private String paymentMethod;
    private String status;

    public PaymentDTO(String paymentId, String reservationId, LocalDate paymentDate, double totalCost, String transactionId, String paymentMethod, String status) {
        this.paymentId = paymentId;
        this.reservationId = reservationId;
        this.paymentDate = paymentDate;
        this.totalCost = totalCost;
        this.transactionId = transactionId;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }

    public String getPaymentId() {return paymentId;}

    public void setPaymentId(String paymentId) {this.paymentId = paymentId;}

    public String getReservationId() {return reservationId;}

    public void setReservationId(String reservationId) {this.reservationId = reservationId;}

    public LocalDate getPaymentDate() {return paymentDate;}

    public void setPaymentDate(LocalDate paymentDate) {this.paymentDate = paymentDate;}

    public double getTotalCost() {return totalCost;}

    public void setTotalCost(double totalCost) {this.totalCost = totalCost;}

    public String getTransactionId() {return transactionId;}

    public void setTransactionId(String transactionId) {this.transactionId = transactionId;}

    public String getPaymentMethod() {return paymentMethod;}

    public void setPaymentMethod(String paymentMethod) {this.paymentMethod = paymentMethod;}

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = status;}

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "paymentId='" + paymentId + '\'' +
                ", reservationId='" + reservationId + '\'' +
                ", paymentDate=" + paymentDate +
                ", totalCost=" + totalCost +
                ", transactionId='" + transactionId + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
