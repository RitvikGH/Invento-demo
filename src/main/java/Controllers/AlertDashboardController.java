package Controllers;

import Application.DTO.AlertSummaryResult;
import ports.IN.QueryLowStockAlertsUseCase;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class AlertDashboardController {

    private final QueryLowStockAlertsUseCase queryLowStockAlertsUseCase;

    public AlertDashboardController(QueryLowStockAlertsUseCase queryLowStockAlertsUseCase) {
        this.queryLowStockAlertsUseCase = queryLowStockAlertsUseCase;
    }

    @GetMapping
    public ResponseEntity<List<AlertSummaryResult>> getLowStockAlerts() {
        List<AlertSummaryResult> alerts = queryLowStockAlertsUseCase.getLowStockAlerts();
        return ResponseEntity.ok(alerts);
    }

}
