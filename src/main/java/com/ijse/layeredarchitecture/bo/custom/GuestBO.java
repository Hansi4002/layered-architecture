package com.ijse.layeredarchitecture.bo.custom;

import com.ijse.layeredarchitecture.bo.SuperBO;
import com.ijse.layeredarchitecture.dto.GuestDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface GuestBO extends SuperBO {
    public ArrayList<GuestDTO> getAllGuest() throws SQLException, ClassNotFoundException;
    public boolean saveGuest(GuestDTO guestDTO) throws SQLException, ClassNotFoundException;
    public boolean deleteGuest(String guest_id) throws SQLException, ClassNotFoundException;
    public boolean updateGuest(GuestDTO guestDTO) throws SQLException, ClassNotFoundException;
    public String generateNewGuestID() throws SQLException, ClassNotFoundException;
    boolean existerGuest(String guestId) throws SQLException, ClassNotFoundException;
    Object searchGuests(String search) throws SQLException, ClassNotFoundException;
}
