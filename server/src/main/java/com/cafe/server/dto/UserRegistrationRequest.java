package com.cafe.server.dto;

public class UserRegistrationRequest {
    
    private String userName;
    private String userEmail;
    private String userUsername;
    private String userPassword;
    
    public UserRegistrationRequest(String userName, String userEmail, String userUsername, String userPassword) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userUsername = userUsername;
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    
}
