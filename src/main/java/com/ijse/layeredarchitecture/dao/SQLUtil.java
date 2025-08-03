package com.ijse.layeredarchitecture.dao;

import com.ijse.layeredarchitecture.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLUtil {
    public static ResultSet executeQuery(String query, Object... ob) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getDbConnection().getConnection();
        PreparedStatement ps = con.prepareStatement(query);
        for (int i = 0; i < ob.length; i++) {
            ps.setObject(i + 1, ob[i]);
        }
        return ps.executeQuery();
    }

    public static boolean executeUpdate(String query, Object... ob) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getDbConnection().getConnection();
        PreparedStatement ps = con.prepareStatement(query);
        for (int i = 0; i < ob.length; i++) {
            ps.setObject(i + 1, ob[i]);
        }
        return ps.executeUpdate()>0;
    }
}
