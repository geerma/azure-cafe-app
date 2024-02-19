package com.cafe.server.user;

import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@NonNull @RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/")
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }
}
