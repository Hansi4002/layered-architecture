package com.ijse.layeredarchitecture.dto;

public class RoomDTO {
    private String roomId;
    private String roomType;
    private double price;
    private String status;
    private String floorNumber;
    private int capacity;
    private String description;
    private String roomNumber;

    public RoomDTO(String roomId, String roomType, double price, String status, String floorNumber, int capacity, String description, String roomNumber) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.price = price;
        this.status = status;
        this.floorNumber = floorNumber;
        this.capacity = capacity;
        this.description = description;
        this.roomNumber = roomNumber;
    }

    public String getRoomId() {return roomId;}

    public void setRoomId(String roomId) {this.roomId = roomId;}

    public String getRoomType() {return roomType;}

    public void setRoomType(String roomType) {this.roomType = roomType;}

    public double getPrice() {return price;}

    public void setPrice(double price) {this.price = price;}

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = status;}

    public String getFloorNumber() {return floorNumber;}

    public void setFloorNumber(String floorNumber) {this.floorNumber = floorNumber;}

    public int getCapacity() {return capacity;}

    public void setCapacity(int capacity) {this.capacity = capacity;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public String getRoomNumber() {return roomNumber;}

    public void setRoomNumber(String roomNumber) {this.roomNumber = roomNumber;}

    @Override
    public String toString() {
        return "RoomDTO{" +
                "roomId='" + roomId + '\'' +
                ", roomType='" + roomType + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", floorNumber='" + floorNumber + '\'' +
                ", capacity=" + capacity +
                ", description='" + description + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                '}';
    }
}
