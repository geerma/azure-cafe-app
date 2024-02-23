package com.cafe.server.product.merchandise;

import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/merchandises")
public class MerchandiseController {

    private final MerchandiseRepository merchandiseRepository;

    public MerchandiseController(MerchandiseRepository merchandiseRepository) {
        this.merchandiseRepository = merchandiseRepository;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Merchandise createMerchandise(@NonNull @RequestBody Merchandise merchandise) {
        return merchandiseRepository.save(merchandise);
    }

    @GetMapping("/")
    public Iterable<Merchandise> getMerchandises() {
        return merchandiseRepository.findAll();
    }
}
