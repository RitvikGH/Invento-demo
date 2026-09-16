package Application.Services;
import java.util.List;
import java.util.stream.Collectors;

import Application.DTO.AlertSummaryResult;
import Models.AlertLog;
import ports.IN.QueryLowStockAlertsUseCase;
import ports.OUT.AlertLogRepositoryPort;

public class AlertDashboardService implements QueryLowStockAlertsUseCase  {
    private final AlertLogRepositoryPort alertLogRepository;

    public AlertDashboardService(AlertLogRepositoryPort alertLogRepository) {
        this.alertLogRepository = alertLogRepository;
    }

    @Override
    public List<AlertSummaryResult> getLowStockAlerts() {
        // 1. Fetch domain models from the repository
        List<AlertLog> domainLogs = alertLogRepository.findLatestAlerts(50);
        
        // 2. Map them to DTOs for the controller
        return domainLogs.stream()
            .map(log -> new AlertSummaryResult(
                log.getId(),
                log.getProductId(),
                log.getTriggeredQuantity(),
                log.getCreatedAt()
            ))
            .collect(Collectors.toList());
}
}
