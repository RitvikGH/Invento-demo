package com.invento.ims.infrastructure.adapter.OUT.persistence;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.invento.ims.Domain.Models.AlertLog;
import com.invento.ims.Domain.port.OUT.AlertLogRepositoryPort;
import com.invento.ims.infrastructure.adapter.OUT.persistence.Entity.AlertLogJpaEntity;
import com.invento.ims.infrastructure.adapter.OUT.persistence.dataRepo.SpringDataAlertLogRepo;

@Component 
public class PostgresAlertLogAdapter implements AlertLogRepositoryPort{
    private final SpringDataAlertLogRepo jpaRepo;

    public PostgresAlertLogAdapter(SpringDataAlertLogRepo jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public boolean hasRecentAlert(String productId, Instant since) {
        return jpaRepo.existsByProductIdAndCreatedAtAfter(productId, since);
    }

    @Override
    public void save(AlertLog alertLog) {
        AlertLogJpaEntity entity = new AlertLogJpaEntity(
            alertLog.getId(),
            alertLog.getProductId(),
            alertLog.getTriggeredQuantity(),
            alertLog.getCreatedAt()
        );
        jpaRepo.save(entity);
    }

    @Override
    public List<AlertLog> findLatestAlerts(int limit) {
        return jpaRepo.findTop50ByOrderByCreatedAtDesc().stream()
            .map(entity -> new AlertLog(
                entity.getId(), 
                entity.getProductId(), 
                entity.getTriggeredQuantity(), 
                entity.getCreatedAt()
            ))
            .collect(Collectors.toList());
    }
}
