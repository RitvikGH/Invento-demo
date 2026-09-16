package com.invento.ims.application.services;
import java.util.List;
import java.util.stream.Collectors;

import com.invento.ims.Domain.port.IN.QueryLowStockAlertsUseCase;
import com.invento.ims.Domain.port.OUT.AlertLogRepositoryPort;
import com.invento.ims.application.dto.AlertSummaryResult;

import com.invento.ims.Domain.Models.AlertLog;

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
