package com.cafe.server.dto;

public class UserLoginRequest {

    private String userUsername;
    private String userPassword;

    public UserLoginRequest(String userUsername, String userPassword) {
        this.userUsername = userUsername;
        this.userPassword = userPassword;
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
