package com.cafe.server.user;

import java.util.Optional;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class CafeUserController {

    private final CafeUserRepository cafeUserRepository;

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
    public Optional<CafeUser> getUserById(@PathVariable("userid") Long userid) {
        return cafeUserRepository.findById(userid);
    }

}
