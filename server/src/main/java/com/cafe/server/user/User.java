package com.cafe.server.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cafe_user")
public abstract class User {

    @Id
    @GeneratedValue
    private Long userId;
    private String userName;
    private String userUsername;
    private String userPassword;
    private String userRole;

    protected User() {
        
    }

    protected User(String userName, String userUsername, String userPassword, String userRole) {
        this.userName = userName;
        this.userUsername = userUsername;
        this.userPassword = userPassword;
        this.userRole = userRole;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        return userId != null && userId.equals(((User) o).userId);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
