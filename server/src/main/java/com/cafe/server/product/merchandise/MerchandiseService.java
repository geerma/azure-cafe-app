package com.cafe.server.product.merchandise;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MerchandiseService {

    private final MerchandiseRepository merchandiseRepository;

    public MerchandiseService(MerchandiseRepository merchandiseRepository) {
        this.merchandiseRepository = merchandiseRepository;
    }

    public Merchandise getMerchandiseByProductId(@NonNull Long productId) throws Exception {
        Optional<Merchandise> merchandiseOptional = merchandiseRepository.findById(productId);

        // Check if Merchandise is present in the optional
        if (merchandiseOptional.isPresent()) {
            Merchandise merchandise = merchandiseOptional.get();
            return merchandise;
        } else {
            throw new Exception("Merchandise with ID " + productId + " not found");
        }
    }

    public Merchandise createMerchandise(String productName, String productDescription, String productCategory,
            Double productCost) {
        Merchandise newMerchandise = new Merchandise(productName, productDescription, productCategory, productCost);
        return merchandiseRepository.save(newMerchandise);
    }

}
