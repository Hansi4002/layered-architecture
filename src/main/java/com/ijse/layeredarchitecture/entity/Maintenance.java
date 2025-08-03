package com.ijse.layeredarchitecture.entity;

public class Maintenance {
    private String maintenanceId;
    private String description;
    private String staffId;
    private String roomId;
    private String status;

    public Maintenance(String maintenanceId, String description, String staffId, String roomId, String status) {
        this.maintenanceId = maintenanceId;
        this.description = description;
        this.staffId = staffId;
        this.roomId = roomId;
        this.status = status;
    }

    public String getMaintenanceId() {return maintenanceId;}

    public void setMaintenanceId(String maintenanceId) {this.maintenanceId = maintenanceId;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public String getStaffId() {return staffId;}

    public void setStaffId(String staffId) {this.staffId = staffId;}

    public String getRoomId() {return roomId;}

    public void setRoomId(String roomId) {this.roomId = roomId;}

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = status;}
}
