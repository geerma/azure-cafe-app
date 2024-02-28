package com.cafe.server.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class CafeUserController {

    private final CafeUserRepository cafeUserRepository;

    @Autowired
    public CafeUserController(CafeUserRepository cafeUserRepository) {
        this.cafeUserRepository = cafeUserRepository;
    }

    @GetMapping("/")
    public Iterable<CafeUser> getUsers() {
        return cafeUserRepository.findAll();
    }

    @GetMapping("/username/{username}")
    public Optional<CafeUser> getUserByUsername(@PathVariable("username") String username) {
        return cafeUserRepository.findByUsername(username);
    }

    @GetMapping("/userid/{userid}")
    public Optional<CafeUser> getUserById(@PathVariable("userid") Long userId) {
        return cafeUserRepository.findById(userId);
    }

}
