package com.invento.ims.infrastructure.adapter.OUT.persistence;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.invento.ims.infrastructure.adapter.OUT.persistence.Entity.ProductJpaEntity;
import com.invento.ims.infrastructure.adapter.OUT.persistence.dataRepo.SpringDataProductRepo;

import com.invento.ims.Domain.Models.Product;
import com.invento.ims.Domain.port.OUT.ProductRepositoryPort;

@Component 
public class PostgresProductAdapter implements ProductRepositoryPort{
    private final SpringDataProductRepo jpaRepo;

    public PostgresProductAdapter(SpringDataProductRepo jpaRepo) {
        this.jpaRepo = jpaRepo;
}
@Override
    public Optional<Product> findById(String id) {
        // Map JPA Entity -> Domain Model
        return jpaRepo.findById(id).map(entity -> 
            new Product(entity.getName(),entity.getId(), entity.getSku(), entity.getSupplierId(), entity.getAvailableQuantity())
        );
    }
@Override
    public void save(Product product) {
        // Map Domain Model -> JPA Entity
        ProductJpaEntity entity = new ProductJpaEntity(
            product.getProdName(),
            product.getProdID(), 
            product.getSKU(), 
            product.getSupplierID(), 
            product.getStockQuantity()
        );
        jpaRepo.save(entity);
    }

}
