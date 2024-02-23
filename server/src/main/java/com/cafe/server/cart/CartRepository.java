package com.cafe.server.cart;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

public interface CartRepository extends JpaRepository<Cart, Long> {

    @SuppressWarnings("null")
    @EntityGraph(attributePaths = "cartItems")
    Optional<Cart> findById(@NonNull Long userId);
    
}
