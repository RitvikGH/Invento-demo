package com.invento.ims.infrastructure.adapter.OUT.persistence.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class ProductJpaEntity {
    @Id
    private String name;
    private String id;
    private String sku;
    private String supplierId;
    private int availableQuantity;

    protected ProductJpaEntity() {}
    public ProductJpaEntity(String name,String id, String sku, String supplierId, int availableQuantity) {
        this.name = name;
        this.id = id;
        this.sku = sku;
        this.supplierId = supplierId;
        this.availableQuantity = availableQuantity;
    }

    public String getName() { return name; }
    public String getId() { return id; }
    public String getSku() { return sku; }
    public String getSupplierId() { return supplierId; }
    public int getAvailableQuantity() { return availableQuantity; }

}
