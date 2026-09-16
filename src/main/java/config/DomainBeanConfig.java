package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Application.Services.AlertDashboardService;
import Application.Services.InventoryAlertService;
import Application.Services.SupplierManagementService;
import ports.OUT.AlertLogRepositoryPort;
import ports.OUT.ProductRepositoryPort;
import ports.OUT.SupplierRepositoryPort;
import ports.OUT.ThresholdRepositoryPort;

@Configuration 
public class DomainBeanConfig {

    @Bean 
    public InventoryAlertService inventoryAlertService(
            ProductRepositoryPort productRepository,
            ThresholdRepositoryPort thresholdRepository,
            AlertLogRepositoryPort alertLogRepository) {
        // Spring automatically passes in your Postgres adapters here
        return new InventoryAlertService(productRepository, thresholdRepository, alertLogRepository);
    }

    @Bean 
    public AlertDashboardService alertDashboardService(AlertLogRepositoryPort alertLogRepository) {
        return new AlertDashboardService(alertLogRepository);
    }

    @Bean 
    public SupplierManagementService supplierManagementService(
            SupplierRepositoryPort supplierRepository,
            ProductRepositoryPort productRepository) {
        return new SupplierManagementService(supplierRepository, productRepository);
    }

}
