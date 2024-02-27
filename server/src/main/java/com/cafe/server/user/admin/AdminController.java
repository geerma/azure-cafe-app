package com.cafe.server.user.admin;

import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import com.cafe.server.dto.UserRegistrationRequest;

@RestController
@RequestMapping("/api/v1/admins")
public class AdminController {

    private final AdminRepository adminRepository;

    public AdminController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @GetMapping("/")
    public Iterable<Admin> getTodos() {
        return adminRepository.findAll();
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin createAdmin(@NonNull @RequestBody UserRegistrationRequest userRegistrationRequest) {
        // Implement Admin creation with a hashed password. Should be in AuthController
        Admin newAdmin = new Admin(userRegistrationRequest.getUsername(), userRegistrationRequest.getPassword(),
                userRegistrationRequest.getEmail());

        return adminRepository.save(newAdmin);
    }

}
