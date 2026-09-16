package com.invento.ims.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.invento.ims.Domain.port.OUT.AlertLogRepositoryPort;
import com.invento.ims.Domain.port.OUT.ProductRepositoryPort;
import com.invento.ims.Domain.port.OUT.SupplierRepositoryPort;
import com.invento.ims.Domain.port.OUT.ThresholdRepositoryPort;
import com.invento.ims.application.services.AlertDashboardService;
import com.invento.ims.application.services.InventoryAlertService;
import com.invento.ims.application.services.SupplierManagementService;

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
