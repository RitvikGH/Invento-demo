package Adapters.OUT.persistence.DataRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Adapters.OUT.persistence.Entity.SupplierJpaEntity;

@Repository 
public interface SpringDataSupplierRepo extends JpaRepository<SupplierJpaEntity, String> {

}
