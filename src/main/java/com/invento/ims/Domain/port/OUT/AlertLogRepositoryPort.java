package com.invento.ims.Domain.port.OUT;
import java.time.Instant;
import java.util.List;

import com.invento.ims.Domain.Models.AlertLog;

public interface AlertLogRepositoryPort {
    boolean hasRecentAlert(String productId, Instant since);
    void save(AlertLog alertLog);
    List<AlertLog> findLatestAlerts(int limit);

}
