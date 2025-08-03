package com.ijse.layeredarchitecture.entity;

public class User {
    private String userId;
    private String email;
    private String password;
    private String role;
    private String name;
    private String profilePicPath;

    public User(String userId, String email, String password, String role, String name, String profilePicPath) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.role = role;
        this.name = name;
        this.profilePicPath = profilePicPath;
    }

    public String getUserId() {return userId;}

    public void setUserId(String userId) {this.userId = userId;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getRole() {return role;}

    public void setRole(String role) {this.role = role;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getProfilePicPath() {return profilePicPath;}

    public void setProfilePicPath(String profilePicPath) {this.profilePicPath = profilePicPath;}
}
