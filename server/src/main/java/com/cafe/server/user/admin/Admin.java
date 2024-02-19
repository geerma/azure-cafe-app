package com.cafe.server.user.admin;

import javax.persistence.Entity;

import com.cafe.server.user.User;

@Entity
public class Admin extends User {

    protected Admin() {
        
    }

    public Admin(String userName, String userUsername, String userPassword, String userRole, String billingAddress,
            String paymentMethod) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Admin)) {
            return false;
        }
        Admin otherAdmin = (Admin) o;
        return getUserId() != null && getUserId().equals(otherAdmin.getUserId());
    }

    @Override
    public int hashCode() {
        return 31;
    }
}