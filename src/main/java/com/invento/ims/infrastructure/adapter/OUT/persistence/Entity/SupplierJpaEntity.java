package com.invento.ims.infrastructure.adapter.OUT.persistence.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "suppliers")
public class SupplierJpaEntity {
    @Id 
    private String id;
    private String name;
    private String contactEmail;

    protected SupplierJpaEntity() {}

    public SupplierJpaEntity(String id, String name, String contactEmail) {
        this.id = id;
        this.name = name;
        this.contactEmail = contactEmail;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getContactEmail() { return contactEmail; }

}
