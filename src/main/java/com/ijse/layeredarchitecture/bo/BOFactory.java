package com.ijse.layeredarchitecture.bo;

import com.ijse.layeredarchitecture.bo.impl.GuestBOImpl;
import com.ijse.layeredarchitecture.dao.SuperDAO;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory() {}

    public static BOFactory getBoFactory() {
        return (boFactory == null) ? new BOFactory() : boFactory;
    }

    public enum BOTypes {
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

    public SuperBO getBO(BOTypes type) {
        switch (type){
            case GUEST:
                return new GuestBOImpl();
            default:
                return null;
        }
    }
}
