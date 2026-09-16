package com.invento.ims.application.dto;
import java.time.Instant;

public record AlertSummaryResult(
    String alertId,
    String productId,
    int triggeredQuantity,
    Instant createdAt
) {}

