package com.invento.ims.infrastructure.adapter.OUT.persistence.dataRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.invento.ims.infrastructure.adapter.OUT.persistence.Entity.ThresholdJpaEntity;

@Repository
public interface SpringDataThresholdRepo
        extends JpaRepository<ThresholdJpaEntity, String> {

}
