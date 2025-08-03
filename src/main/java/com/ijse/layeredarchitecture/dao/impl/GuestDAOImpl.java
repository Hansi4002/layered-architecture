package com.ijse.layeredarchitecture.dao.impl;

import com.ijse.layeredarchitecture.dao.SQLUtil;
import com.ijse.layeredarchitecture.dao.custom.GuestDAO;
import com.ijse.layeredarchitecture.entity.Guest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GuestDAOImpl implements GuestDAO {
    public ArrayList<Guest> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.executeQuery("SELECT * FROM GUEST");
        ArrayList<Guest> guests = new ArrayList<>();
        while (rs.next()) {
            Guest entity = new Guest(rs.getString("guest_id"), rs.getString("name"), rs.getDate("dob").toLocalDate(), rs.getString("address"), rs.getString("contact"), rs.getString("email"), rs.getDate("registration_date").toLocalDate(), rs.getString("loyalty_status"));
            guests.add(entity);
        }
        return guests;
    }
    public boolean save(Guest entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("INSERT INTO Guest (guest_id, name, dob, address, contact, email, registration_date, loyalty_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                entity.getGuestId(),entity.getName(),entity.getDob(),entity.getAddress(),entity.getContact(),entity.getEmail(),entity.getRegistrationDate(),entity.getLoyaltyStatus());
    }
    public boolean delete(String guest_id) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("DELETE FROM Guest WHERE guest_id=?",guest_id);
    }
    public boolean update(Guest entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("UPDATE Guest SET name=?, dob=?, address=?, contact=?, email=?, registration_date=?, loyalty_status=? WHERE guest_id=?",
                entity.getName(),entity.getDob(),entity.getAddress(),entity.getContact(),entity.getEmail(),entity.getRegistrationDate(),entity.getLoyaltyStatus(),entity.getGuestId());
    }
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.executeQuery("SELECT * FROM GUEST ORDER BY guest_id DESC");
        if (rs.next()) {
            String guest_id = rs.getString("guest_id");
            int newGuest_id = Integer.parseInt(guest_id.replace("G",""))+1;
            return String.format("G%03d",newGuest_id);
        }else {
            return "G001";
        }
    }
    public boolean exist(String guest_id) throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.executeQuery("SELECT guest_id FROM GUEST WHERE guest_id=?",guest_id);
        return rs.next();
    }
    public Guest search(String guest_id) throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.executeQuery("SELECT * FROM GUEST WHERE guest_id=?",guest_id);
        rs.next();
        return new Guest(guest_id+"", rs.getString("name"), rs.getDate("dob").toLocalDate(),rs.getString("address"),rs.getString("contact"),rs.getString("email"), rs.getDate("registration_date").toLocalDate(),rs.getString("loyalty_status"));
    }
}

