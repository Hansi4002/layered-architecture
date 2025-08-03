package com.ijse.layeredarchitecture.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CurdDAO<T> extends SuperDAO {
    ArrayList<T> getAll() throws SQLException, ClassNotFoundException;
    boolean save(T guestDTO) throws SQLException, ClassNotFoundException;
    boolean update(T guestDTO) throws SQLException, ClassNotFoundException;
    boolean delete(String guest_id) throws SQLException, ClassNotFoundException;
    String generateNewID() throws SQLException, ClassNotFoundException;
    T search(String guest_id) throws SQLException, ClassNotFoundException;
    boolean exist(String guest_id) throws SQLException, ClassNotFoundException;
}
