package com.ijse.layeredarchitecture.entity;

import java.sql.Date;

public class Staff {
    private String staffId;
    private String userId;
    private String name;
    private String position;
    private String contact;
    private Date hireDate;

    public Staff(String staffId, String userId, String name, String position, String contact, Date hireDate) {
        this.staffId = staffId;
        this.userId = userId;
        this.name = name;
        this.position = position;
        this.contact = contact;
        this.hireDate = hireDate;
    }

    public String getStaffId() {return staffId;}

    public void setStaffId(String staffId) {this.staffId = staffId;}

    public String getUserId() {return userId;}

    public void setUserId(String userId) {this.userId = userId;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getPosition() {return position;}

    public void setPosition(String position) {this.position = position;}

    public String getContact() {return contact;}

    public void setContact(String contact) {this.contact = contact;}

    public Date getHireDate() {return hireDate;}

    public void setHireDate(Date hireDate) {this.hireDate = hireDate;}
}
