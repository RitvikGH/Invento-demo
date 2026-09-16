//This is in test mode right now, not to be compiled for shit.

package Models;

import java.time.Instant;

public class AlertLog {
    private final String id;
    private final String productId;
    private final int triggeredQuantity;
    private final Instant createdAt;

    public AlertLog(String id, String productId, int triggeredQuantity, Instant createdAt) {
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