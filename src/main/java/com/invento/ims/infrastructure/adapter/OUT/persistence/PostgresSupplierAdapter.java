package com.invento.ims.infrastructure.adapter.OUT.persistence;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.invento.ims.infrastructure.adapter.OUT.persistence.Entity.SupplierJpaEntity;
import com.invento.ims.infrastructure.adapter.OUT.persistence.dataRepo.SpringDataSupplierRepo;

import com.invento.ims.Domain.Models.Supplier;
import com.invento.ims.Domain.port.OUT.SupplierRepositoryPort;

@Component 
public class PostgresSupplierAdapter implements SupplierRepositoryPort {
    private final SpringDataSupplierRepo jpaRepo;

    public PostgresSupplierAdapter(SpringDataSupplierRepo jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public Optional<Supplier> findById(String id) {
        return jpaRepo.findById(id).map(entity -> 
            new Supplier(entity.getId(), entity.getName(), entity.getContactEmail())
        );
    }

    @Override
    public void save(Supplier supplier) {
        // Remember: Supplier is a Java Record, so we use .id(), .name() instead of .getId()
        SupplierJpaEntity entity = new SupplierJpaEntity(
            supplier.getSupplierID(), 
            supplier.getSupplierName(), 
            supplier.getSupplierEmail()
        );
        jpaRepo.save(entity);
    }

}
