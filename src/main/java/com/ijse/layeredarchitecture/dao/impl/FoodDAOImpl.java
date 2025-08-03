package com.ijse.layeredarchitecture.dao.impl;

import com.ijse.layeredarchitecture.dao.SQLUtil;
import com.ijse.layeredarchitecture.dao.custom.FoodDAO;
import com.ijse.layeredarchitecture.entity.Food;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FoodDAOImpl implements FoodDAO {
    public ArrayList<Food> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.executeQuery("SELECT * FROM FOOD");
        ArrayList<Food> foods = new ArrayList<>();
        while (rs.next()) {
            Food entity = new Food(rs.getString("menu_id"),
                    rs.getString("avaialble"),
                    rs.getString("category"),
                    rs.getDouble("price"),
                    rs.getString("item_name"),
                    rs.getString("description"));
            foods.add(entity);
        }
        return foods;
    }
    public boolean save(Food entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("INSERT INTO food (menu_id, avaialble, category, price, item_name, description) VALUES (?, ?, ?, ?, ?, ?)",
                entity.getMenuId(), entity.getAvailable(), entity.getCategory(), entity.getPrice(), entity.getItemName(), entity.getDescription());
    }
    public boolean delete(String menuId) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("DELETE FROM food WHERE menu_id = ?", menuId);
    }
    public boolean update(Food entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("UPDATE Food SET  avaialble=?, category=?, price=?, item_name=?, description=? WHERE menu_id=?",
                entity.getAvailable(), entity.getCategory(), entity.getPrice(), entity.getItemName(), entity.getDescription(), entity.getMenuId());
    }
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.executeQuery("SELECT * FROM FOOD ORDER BY menu_id DESC");
        if (rs.next()) {
            String menu_id = rs.getString("menu_id");
            int newMenu_id = Integer.parseInt(menu_id.replace("M",""))+1;
            return String.format("M%03d",newMenu_id);
        }else {
            return "M001";
        }
    }
    public boolean exist(String menuId) throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.executeQuery("SELECT * FROM FOOD WHERE menu_id = ?", menuId);
        return rs.next();
    }
    public Food search(String menuId) throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.executeQuery("SELECT * FROM FOOD WHERE menu_id = ?", menuId);
        rs.next();
        return new Food(menuId+"",rs.getString("avaialble"), rs.getString("category"), rs.getDouble("price"), rs.getString("item_name"), rs.getString("description"));
    }
}
