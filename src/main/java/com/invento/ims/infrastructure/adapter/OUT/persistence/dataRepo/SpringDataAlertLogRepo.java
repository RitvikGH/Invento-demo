package com.invento.ims.infrastructure.adapter.OUT.persistence.dataRepo;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.invento.ims.infrastructure.adapter.OUT.persistence.Entity.AlertLogJpaEntity;

@Repository 
public interface SpringDataAlertLogRepo extends JpaRepository<AlertLogJpaEntity, String> {
    boolean existsByProductIdAndCreatedAtAfter(String productId, Instant time);
    List<AlertLogJpaEntity> findTop50ByOrderByCreatedAtDesc();

}
