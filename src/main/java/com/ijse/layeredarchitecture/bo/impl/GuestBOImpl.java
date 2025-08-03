package com.ijse.layeredarchitecture.bo.impl;

import com.ijse.layeredarchitecture.bo.custom.GuestBO;
import com.ijse.layeredarchitecture.dao.DAOFactory;
import com.ijse.layeredarchitecture.dao.SQLUtil;
import com.ijse.layeredarchitecture.dao.custom.GuestDAO;
import com.ijse.layeredarchitecture.dto.GuestDTO;
import com.ijse.layeredarchitecture.entity.Guest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GuestBOImpl implements GuestBO {
    GuestDAO guestDAO = (GuestDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.GUEST);

    @Override
    public ArrayList<GuestDTO> getAllGuest() throws SQLException, ClassNotFoundException {
        ArrayList<Guest>entity = guestDAO.getAll();
        ArrayList<GuestDTO> guestDTO = new ArrayList<>();
        for (Guest g : entity) {
           guestDTO.add(new GuestDTO(g.getGuestId(),g.getName(), g.getDob(),g.getAddress(),g.getContact(),g.getEmail(), g.getRegistrationDate(),g.getLoyaltyStatus()));
        }
        return guestDTO;
    }

    @Override
    public boolean saveGuest(GuestDTO guestDTO) throws SQLException, ClassNotFoundException {
        return guestDAO.save(new Guest(guestDTO.getGuestId(),guestDTO.getName(),guestDTO.getDob(),guestDTO.getAddress(),guestDTO.getContact(),guestDTO.getEmail(),guestDTO.getRegistrationDate(),guestDTO.getLoyaltyStatus()));
    }

    @Override
    public boolean deleteGuest(String guest_id) throws SQLException, ClassNotFoundException {
        return guestDAO.delete(guest_id);
    }

    @Override
    public boolean updateGuest(GuestDTO guestDTO) throws SQLException, ClassNotFoundException {
        return guestDAO.update(new Guest(guestDTO.getGuestId(),guestDTO.getName(),guestDTO.getDob(),guestDTO.getAddress(),guestDTO.getContact(),guestDTO.getEmail(),guestDTO.getRegistrationDate(),guestDTO.getLoyaltyStatus()));
    }

    @Override
    public String generateNewGuestID() throws SQLException, ClassNotFoundException {
        return guestDAO.generateNewID();
    }

    @Override
    public boolean existerGuest(String guestId) throws SQLException, ClassNotFoundException {
        return guestDAO.exist(guestId);
    }

    @Override
    public Object searchGuests(String search) throws SQLException, ClassNotFoundException {
        return guestDAO.search(search);
    }
}
