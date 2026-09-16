package ports.OUT;
import java.time.Instant;
import java.util.List;

import Models.AlertLog;

public interface AlertLogRepositoryPort {
    boolean hasRecentAlert(String productId, Instant since);
    void save(AlertLog alertLog);
    List<AlertLog> findLatestAlerts(int limit);

}
