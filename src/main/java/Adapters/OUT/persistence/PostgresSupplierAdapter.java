package Adapters.OUT.persistence;

import java.util.Optional;

import org.springframework.stereotype.Component;

import Adapters.OUT.persistence.DataRepository.SpringDataSupplierRepo;
import Adapters.OUT.persistence.Entity.SupplierJpaEntity;
import Models.Supplier;
import ports.OUT.SupplierRepositoryPort;

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
