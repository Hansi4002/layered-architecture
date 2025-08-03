package com.ijse.layeredarchitecture.dao.impl;

import com.ijse.layeredarchitecture.dao.SQLUtil;
import com.ijse.layeredarchitecture.dao.custom.RoomDAO;
import com.ijse.layeredarchitecture.entity.Guest;
import com.ijse.layeredarchitecture.entity.Room;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomDAOImpl implements RoomDAO {
    public ArrayList<Room> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.executeQuery("SELECT * FROM ROOM");
        ArrayList<Room> rooms = new ArrayList<>();
        while (rs.next()) {
            Room entity = new Room(rs.getString("room_id"),
                    rs.getString("room_type"),
                    rs.getDouble("price"),
                    rs.getString("status"),
                    rs.getString("floor_number"),
                    rs.getInt("capacity"),
                    rs.getString("description"),
                    rs.getString("room_number"));
            rooms.add(entity);
        }
        return rooms;
    }
    public boolean save(Room entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("INSERT INTO room (room_id, room_type, price, status, floor_number, capacity, description, room_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                entity.getRoomId(),entity.getRoomType(),entity.getPrice(),entity.getStatus(),entity.getFloorNumber(),entity.getCapacity(),entity.getDescription(),entity.getRoomNumber());
    }
    public boolean delete(String room_id) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("DELETE FROM Room WHERE room_id=?",room_id);
    }
    public boolean update(Room entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("UPDATE room SET room_type=?, price=?, status=?, floor_number=?, capacity=?, description=?, room_number=? WHERE room_id=?",
                entity.getRoomId(),entity.getRoomType(),entity.getPrice(),entity.getStatus(),entity.getFloorNumber(),entity.getCapacity(),entity.getDescription(),entity.getRoomNumber());
    }
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.executeQuery("SELECT * FROM ROOM ORDER BY room_id DESC");
        if (rs.next()) {
            String room_id = rs.getString("room_id");
            int newRoom_id = Integer.parseInt(room_id.replace("R",""))+1;
            return String.format("R%03d",newRoom_id);
        }else {
            return "R001";
        }
    }
    public boolean exist(String room_id) throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.executeQuery("SELECT room_id FROM ROOM WHERE room_id=?",room_id);
        return rs.next();
    }
    public Room search(String room_id) throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.executeQuery("SELECT * FROM ROOM WHERE room_id=?",room_id);
        rs.next();
        return new Room(room_id+"", rs.getString("room_type"),
                rs.getDouble("price"),
                rs.getString("status"),
                rs.getString("floor_number"),
                rs.getInt("capacity"),
                rs.getString("description"),
                rs.getString("room_number"));
    }
}
