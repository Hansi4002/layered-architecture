package com.ijse.layeredarchitecture.dao.custom;

import com.ijse.layeredarchitecture.dao.CurdDAO;
import com.ijse.layeredarchitecture.entity.FoodOrderDetail;

import java.sql.SQLException;

public interface FoodOrderDetailDAO extends CurdDAO<FoodOrderDetail> {
    boolean delete(String menu_id, String order_id) throws SQLException, ClassNotFoundException;
    boolean exist(String menu_id, String order_id) throws SQLException, ClassNotFoundException;
    FoodOrderDetail search(String menu_id, String order_id) throws SQLException, ClassNotFoundException;
}
