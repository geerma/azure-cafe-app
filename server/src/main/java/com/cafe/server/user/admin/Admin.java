package com.cafe.server.user.admin;

import java.util.Objects;

import javax.persistence.Entity;

import com.cafe.server.user.CafeUser;

@Entity
public class Admin extends CafeUser {

    protected Admin() {
        
    }

    public Admin(String username, String password, String email) {
        super(username, password, email, "ADMIN");
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
        return Objects.hash(this.getUserId());
    }

}