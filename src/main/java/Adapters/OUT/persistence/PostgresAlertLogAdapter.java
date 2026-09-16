package Adapters.OUT.persistence;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import Adapters.OUT.persistence.DataRepository.SpringDataAlertLogRepo;
import Adapters.OUT.persistence.Entity.AlertLogJpaEntity;
import Models.AlertLog;
import ports.OUT.AlertLogRepositoryPort;

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
