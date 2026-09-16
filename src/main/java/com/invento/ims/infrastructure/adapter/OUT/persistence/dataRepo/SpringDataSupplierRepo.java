package com.invento.ims.infrastructure.adapter.OUT.persistence.dataRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.invento.ims.infrastructure.adapter.OUT.persistence.Entity.SupplierJpaEntity;

@Repository 
public interface SpringDataSupplierRepo extends JpaRepository<SupplierJpaEntity, String> {

}
