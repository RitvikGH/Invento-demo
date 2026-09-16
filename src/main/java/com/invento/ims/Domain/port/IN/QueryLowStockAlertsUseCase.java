package com.invento.ims.Domain.port.IN;
import java.util.List;

import com.invento.ims.application.dto.AlertSummaryResult;

public interface QueryLowStockAlertsUseCase {
    List<AlertSummaryResult> getLowStockAlerts();

}
