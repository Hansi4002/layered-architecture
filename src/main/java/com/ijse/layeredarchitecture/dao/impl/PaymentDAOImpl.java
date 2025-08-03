package com.ijse.layeredarchitecture.dao.impl;

import com.ijse.layeredarchitecture.dao.SQLUtil;
import com.ijse.layeredarchitecture.dao.custom.PaymentDAO;
import com.ijse.layeredarchitecture.entity.Payment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentDAOImpl implements PaymentDAO {
    public ArrayList<Payment> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.executeQuery("SELECT * FROM PAYMENT");
        ArrayList<Payment> payments = new ArrayList<>();
        while (rs.next()) {
            Payment entity = new Payment(rs.getString("payment_id"),
                    rs.getString("reservation_id"),
                    rs.getDate("payment_date").toLocalDate(),
                    rs.getDouble("total_cost"),
                    rs.getString("transaction_id"),
                    rs.getString("payment_method"),
                    rs.getString("status"));
            payments.add(entity);
        }
        return payments;
    }
    public boolean save(Payment entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("INSERT INTO Payment (payment_id, reservation_id, payment_date, total_cost, transaction_id, payment_method, status) VALUES (?, ?, ?, ?, ?, ?, ?)",
                entity.getPaymentId(),entity.getReservationId(),entity.getPaymentDate(),entity.getTotalCost(),entity.getTransactionId(),entity.getPaymentMethod(),entity.getStatus());
    }
    public boolean delete(String payment_id) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("DELETE FROM Payment WHERE payment_id = ?", payment_id);
    }
    public boolean update(Payment entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("UPDATE Payment SET reservation_id = ?, payment_date = ?, total_cost = ?, transaction_id = ?, payment_method = ?, status = ? WHERE payment_id = ?",
                entity.getReservationId(),entity.getPaymentDate(),entity.getTotalCost(),entity.getTransactionId(),entity.getPaymentMethod(),entity.getStatus());
    }
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.executeQuery("SELECT * FROM Payment ORDER BY payment_id DESC");
        if (rs.next()) {
            String payment_id = rs.getString("payment_id");
            int newPayment_id = Integer.parseInt(payment_id.replace("P",""));
            return String.format("%03d",newPayment_id);
        }else {
            return "P001";
        }
    }
    public boolean exist(String payment_id) throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.executeQuery("SELECT * FROM Payment WHERE payment_id = ?", payment_id);
        return rs.next();
    }
    public Payment search(String payment_id) throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.executeQuery("SELECT * FROM Payment WHERE payment_id = ?", payment_id);
        rs.next();
        return new Payment(payment_id+"",rs.getString("reservation_id"), rs.getDate("payment_date").toLocalDate(),rs.getDouble("total_cost"),rs.getString("transaction_id"),rs.getString("payment_method"),rs.getString("status"));
    }
}
