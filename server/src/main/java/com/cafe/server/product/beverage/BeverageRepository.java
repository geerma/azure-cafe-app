package com.cafe.server.product.beverage;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BeverageRepository extends JpaRepository<Beverage, Long> {
}
