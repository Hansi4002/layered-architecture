package com.ijse.layeredarchitecture.dao;

import com.ijse.layeredarchitecture.dao.impl.GuestDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory() {}

    public static DAOFactory getInstance() {
        return (daoFactory == null) ? new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        GUEST,
        ROOM,
        RESERVATION,
        PAYMENT,
        FOOD,
        FOOD_ORDER,
        FOOD_ORDER_DETAILS,
        SUPPLIER,
        SUPPLIER_DETAILS,
        MAINTENANCE,
        STAFF,
        USER,
        QUERY
    }

    public SuperDAO getDAO(DAOTypes daoType){
        switch (daoType){
            case GUEST:
                return new GuestDAOImpl();
            default:
                return null;
        }
    }
}
