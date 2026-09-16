package com.invento.ims.infrastructure.adapter.OUT.persistence.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "threshold_settings")
public class ThresholdJpaEntity {

    @Id
    private String id;

    private String productName;
    private String sku;
    private String supplierId;
    private int stockQuantity;
    private int lowStockTrigger;

    protected ThresholdJpaEntity() {
    }

    public ThresholdJpaEntity(
            String id,
            String productName,
            String sku,
            String supplierId,
            int stockQuantity,
            int lowStockTrigger) {

        this.id = id;
        this.productName = productName;
        this.sku = sku;
        this.supplierId = supplierId;
        this.stockQuantity = stockQuantity;
        this.lowStockTrigger = lowStockTrigger;
    }

    public String getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getSku() {
        return sku;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public int getLowStockTrigger() {
        return lowStockTrigger;
    }
}                
