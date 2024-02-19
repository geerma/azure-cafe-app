package com.cafe.server.user.admin;

import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AdminController {

    private final AdminRepository adminRepository;

    public AdminController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin createTodo(@NonNull @RequestBody Admin admin) {
        return adminRepository.save(admin);
    }

    @GetMapping("/")
    public Iterable<Admin> getTodos() {
        return adminRepository.findAll();
    }
}
