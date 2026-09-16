package Adapters.OUT.persistence.Entity;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity 
@Table(name = "alert_logs")
public class AlertLogJpaEntity {
    @Id 
    private String id;
    private String productId;
    private int triggeredQuantity;
    private Instant createdAt;

    protected AlertLogJpaEntity() {}

    //constructor for creating a new entry in the database 

    public AlertLogJpaEntity(String id, String productId, int triggeredQuantity, Instant createdAt) {
        this.id = id;
        this.productId = productId;
        this.triggeredQuantity = triggeredQuantity;
        this.createdAt = createdAt;
    }

    public String getId() { return id; }
    public String getProductId() { return productId; }
    public int getTriggeredQuantity() { return triggeredQuantity; }
    public Instant getCreatedAt() { return createdAt; }
}
