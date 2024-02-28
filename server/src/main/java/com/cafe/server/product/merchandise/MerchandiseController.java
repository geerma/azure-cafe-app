package com.cafe.server.product.merchandise;

import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/merchandises")
public class MerchandiseController {

    private final MerchandiseRepository merchandiseRepository;

    public MerchandiseController(MerchandiseRepository merchandiseRepository) {
        this.merchandiseRepository = merchandiseRepository;
    }

    @GetMapping("/")
    public Iterable<Merchandise> getMerchandises() {
        return merchandiseRepository.findAll();
    }

    @PostMapping("/createmerchandise")
    @ResponseStatus(HttpStatus.CREATED)
    public Merchandise createMerchandise(@NonNull @RequestBody Merchandise merchandise) {
        // Implement merchandise creation
        return merchandiseRepository.save(merchandise);
    }

}
