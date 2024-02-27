package com.cafe.server.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cafe.server.user.CafeUser;
import com.cafe.server.user.CafeUserRepository;

/**
 * Retrieving username and password from Dao
 * https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/user-details-service.html
 */
@Service
public class CafeUserDetailsService implements UserDetailsService {

    @Autowired
    private CafeUserRepository cafeUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<CafeUser> cafeUser = cafeUserRepository.findByUsername(username);

        if (cafeUser.isPresent()) {
            var userObject = cafeUser.get();
            return userObject;
            // return User.builder().username(userObject.getUsername()).password(userObject.getPassword())
            //         .roles(userObject.getRole()).build();
        } else {
            throw new UsernameNotFoundException(username);
        }
    }

    public UserDetails loadUserById(Long id) throws IndexOutOfBoundsException {

        Optional<CafeUser> cafeUser = cafeUserRepository.findById(id);

        if (cafeUser.isPresent()) {
            var userObject = cafeUser.get();
            return userObject;
            // return User.builder().username(userObject.getUsername()).password(userObject.getPassword())
            //         .roles(userObject.getRole()).build();
        } else {
            throw new IndexOutOfBoundsException(id);
        }
    }

}
