package Adapters.OUT.persistence.DataRepository;

import Adapters.OUT.persistence.Entity.AlertLogJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.Instant;
import java.util.List;

@Repository 
public interface SpringDataAlertLogRepo extends JpaRepository<AlertLogJpaEntity, String> {
    boolean existsByProductIdAndCreatedAtAfter(String productId, Instant time);
    List<AlertLogJpaEntity> findTop50ByOrderByCreatedAtDesc();

}
