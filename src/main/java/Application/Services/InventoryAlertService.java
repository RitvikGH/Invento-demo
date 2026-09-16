package Application.Services;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import Models.AlertLog;
import Models.Product;
import ports.IN.ProcessInventoryUpdateUseCase;
import ports.OUT.AlertLogRepositoryPort;
import ports.OUT.ProductRepositoryPort;
import ports.OUT.ThresholdRepositoryPort;

public class InventoryAlertService implements ProcessInventoryUpdateUseCase  {
    private final ProductRepositoryPort productRepository;
    private final ThresholdRepositoryPort thresholdRepository;
    private final AlertLogRepositoryPort alertLogRepository;

    public InventoryAlertService(ProductRepositoryPort productRepository, 
                                 ThresholdRepositoryPort thresholdRepository, 
                                 AlertLogRepositoryPort alertLogRepository) {
        this.productRepository = productRepository;
        this.thresholdRepository = thresholdRepository;
        this.alertLogRepository = alertLogRepository;
        }

        @Override
    public void processUpdate(String productId, int newAvailableQuantity) {
        // 1. Update the core product aggregate
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new IllegalArgumentException("Unknown Product ID: " + productId));
        
        product.setStockQuantity(newAvailableQuantity);
        productRepository.save(product);

        // 2. Check threshold rules
        thresholdRepository.findById(productId).ifPresent(threshold -> {
            if (threshold.isBelowThreshold(newAvailableQuantity)) {
                triggerAlertIfNotSpam(productId, newAvailableQuantity);
            }
        });
    }

    private void triggerAlertIfNotSpam(String productId, int quantity) {
        Instant oneHourAgo = Instant.now().minus(1, ChronoUnit.HOURS);
        
        // Prevent duplicate alerts if one fired recently
        if (!alertLogRepository.hasRecentAlert(productId, oneHourAgo)) {
            AlertLog newAlert = new AlertLog(
                UUID.randomUUID().toString(), 
                productId, 
                quantity, 
                Instant.now()
            );
            alertLogRepository.save(newAlert);
        }
    }
}


