package com.ijse.layeredarchitecture.dao.impl;

import com.ijse.layeredarchitecture.dao.SQLUtil;
import com.ijse.layeredarchitecture.dao.custom.MaintenanceDAO;
import com.ijse.layeredarchitecture.entity.Maintenance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MaintenanceDAOImpl implements MaintenanceDAO {
    public ArrayList<Maintenance> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.executeQuery("SELECT * FROM MAINTENANCE");
        ArrayList<Maintenance> maintenances = new ArrayList<>();
        while (rs.next()) {
            Maintenance entity = new Maintenance(rs.getString("maintenance_id"),
                    rs.getString("room_id"),
                    rs.getString("staff_id"),
                    rs.getString("description"),
                    rs.getString("status"));
            maintenances.add(entity);
        }
        return maintenances;
    }
    public boolean save(Maintenance entity) throws SQLException, ClassNotFoundException {
       return SQLUtil.executeUpdate("INSERT INTO Maintenance (maintenance_id, room_id, staff_id, description, status) VALUES (?, ?, ?, ?, ?)",
               entity.getMaintenanceId(), entity.getRoomId(), entity.getStaffId(), entity.getDescription(), entity.getStatus());
    }
    public boolean delete(String maintenance_id) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("DELETE FROM Maintenance WHERE maintenance_id = ?", maintenance_id);
    }
    public boolean update(Maintenance entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("UPDATE Maintenance SET room_id = ?, staff_id = ?, description = ?, status = ? WHERE maintenance_id = ?",
                entity.getRoomId(), entity.getStaffId(), entity.getDescription(), entity.getStatus(), entity.getMaintenanceId());
    }
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.executeQuery("SELECT * FROM Maintenance ORDER BY maintenance_id DESC");
        if (rs.next()) {
            String maintenance_id = rs.getString("maintenance_id");
            int newMaintenance_id = Integer.parseInt(maintenance_id.replace("M","")) + 1;
            return String.format("M%03d", newMaintenance_id);
        }else {
            return "M001";
        }
    }
    public boolean exist(String maintenance_id) throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.executeQuery("SELECT * FROM Maintenance WHERE maintenance_id = ?", maintenance_id);
        return rs.next();
    }
    public Maintenance search(String maintenance_id) throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.executeQuery("SELECT * FROM Maintenance WHERE maintenance_id = ?", maintenance_id);
        rs.next();
        return new Maintenance(maintenance_id+"",rs.getString("room_id"),rs.getString("staff_id"),rs.getString("description"),rs.getString("status"));
    }
}
