package com.ijse.layeredarchitecture.entity;

import java.sql.Date;
import java.time.LocalDate;

public class Guest {
    private String guestId;
    private String name;
    private LocalDate dob;
    private String address;
    private String contact;
    private String email;
    private LocalDate registrationDate;
    private String loyaltyStatus;

    public Guest(String guestId, String name, LocalDate dob, String address, String contact, String email, LocalDate registrationDate, String loyaltyStatus) {
        this.guestId = guestId;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.registrationDate = registrationDate;
        this.loyaltyStatus = loyaltyStatus;
    }

    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getLoyaltyStatus() {
        return loyaltyStatus;
    }

    public void setLoyaltyStatus(String loyaltyStatus) {
        this.loyaltyStatus = loyaltyStatus;
    }
}
