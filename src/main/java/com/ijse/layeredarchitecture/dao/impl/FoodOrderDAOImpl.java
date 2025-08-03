package com.ijse.layeredarchitecture.dao.impl;

import com.ijse.layeredarchitecture.dao.SQLUtil;
import com.ijse.layeredarchitecture.dao.custom.FoodOrderDAO;
import com.ijse.layeredarchitecture.entity.FoodOrder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FoodOrderDAOImpl implements FoodOrderDAO {
    public ArrayList<FoodOrder> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.executeQuery("SELECT * FROM FOOD_ORDER");
        ArrayList<FoodOrder> foodOrders = new ArrayList<>();
        while (rs.next()) {
            FoodOrder entity = new FoodOrder(rs.getString("order_id"),
                    rs.getString("reservation_id"),
                    rs.getString("order_type"),
                    rs.getString("status"),
                    rs.getDouble("total_amount"),
                    rs.getDate("order_date"));
            foodOrders.add(entity);
        }
        return foodOrders;
    }
    public boolean save(FoodOrder entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("INSERT INTO Food_Order (order_id, reservation_id, order_type, status, total_amount, order_date) VALUES (?, ?, ?, ?, ?, ?)",
                entity.getOrderId(), entity.getReservationId(), entity.getOrderType(), entity.getStatus(), entity.getTotalAmount(), entity.getOrderDate());
    }
    public boolean delete(String order_iD) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("DELETE FROM Food_Order WHERE order_id = ?", order_iD);
    }
    public boolean update(FoodOrder entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("UPDATE Food_Order SET reservation_id = ?, order_type = ?, status = ?, total_amount = ?, order_date = ? WHERE order_id = ?",
                entity.getReservationId(), entity.getOrderType(), entity.getStatus(), entity.getTotalAmount(), entity.getOrderDate());
    }
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.executeQuery("SELECT * FROM FOOD_ORDER ORDER BY order_id DESC");
        if (rs.next()) {
            String orderID = rs.getString("order_id");
            int newOrderID = Integer.parseInt(orderID.replace("O","")) + 1;
            return String.format("O%03d", newOrderID);
        }else {
            return "O001";
        }
    }
    public boolean exist(String orderID) throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.executeQuery("SELECT * FROM FOOD_ORDER WHERE order_id = ?",orderID);
        return rs.next();
    }
    public FoodOrder search(String orderID) throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.executeQuery("SELECT * FROM FOOD_ORDER WHERE order_id = ?",orderID);
        rs.next();
        return new FoodOrder(orderID+"",rs.getString("reservation_id"),rs.getString("order_type"),rs.getString("status"),rs.getDouble("total_amount"),rs.getDate("order_date"));
    }
}
