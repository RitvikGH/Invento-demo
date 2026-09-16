package com.invento.ims.Domain.port.OUT;
import java.util.Optional;

import com.invento.ims.Domain.Models.Product;
public interface ProductRepositoryPort {
    Optional<Product> findById(String id);
    void save(Product product);
}
