package ports.IN;
import java.util.List;

import Application.DTO.AlertSummaryResult;

public interface QueryLowStockAlertsUseCase {
    List<AlertSummaryResult> getLowStockAlerts();

}
