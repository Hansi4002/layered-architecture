package com.ijse.layeredarchitecture.dao.impl;

import com.ijse.layeredarchitecture.dao.SQLUtil;
import com.ijse.layeredarchitecture.dao.custom.FoodOrderDetailDAO;
import com.ijse.layeredarchitecture.entity.FoodOrderDetail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FoodOrderDetailDAOImpl implements FoodOrderDetailDAO {
    public ArrayList<FoodOrderDetail> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.executeQuery("SELECT * FROM Food_Order_Detail");
        ArrayList<FoodOrderDetail> foodOrderDetails = new ArrayList<>();
        while (rs.next()) {
            FoodOrderDetail entity = new FoodOrderDetail(rs.getString("menu_id"),
                    rs.getString("order_id"),
                    rs.getDouble("item_price"),
                    rs.getInt("quantity"));
            foodOrderDetails.add(entity);
        }
        return foodOrderDetails;
    }
    public boolean save (FoodOrderDetail entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("INSERT INTO Food_Order_Detail (menu_id, order_id, item_price, quantity) VALUES (?, ?, ?, ?)",
                entity.getMenuId(), entity.getOrderId(), entity.getPrice(), entity.getQuantity());
    }
    public boolean delete (String menu_id,String order_id) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("DELETE FROM Food_Order_Detail WHERE menu_id = ? AND order_id = ?", menu_id, order_id);
    }
    public boolean update (FoodOrderDetail entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("UPDATE Food_Order_Detail SET item_price = ?, quantity = ? WHERE menu_id = ? AND order_id = ?,",
                entity.getPrice(), entity.getQuantity(), entity.getMenuId(), entity.getOrderId());
    }
    public boolean exist(String menu_id,String order_id) throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.executeQuery("SELECT * FROM Food_Order_Detail WHERE menu_id = ? AND order_id = ?", menu_id, order_id);
        return rs.next();
    }
    public FoodOrderDetail search(String menu_id,String order_id) throws SQLException, ClassNotFoundException {
       ResultSet rs = SQLUtil.executeQuery("SELECT * FROM FOOD_ORDER_DETAIL WHERE menu_id = ? AND order_id = ?", menu_id,order_id);
       rs.next();
       return new FoodOrderDetail(menu_id+"",order_id+"",rs.getDouble("item_price"),rs.getInt("quantity"));
    }
    @Override
    public boolean delete(String guest_id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public FoodOrderDetail search(String guest_id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean exist(String guest_id) throws SQLException, ClassNotFoundException {
        return false;
    }
}