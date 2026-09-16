package com.invento.ims.Domain.port.IN;

public interface ProcessInventoryUpdateUseCase {
    void processUpdate(String productId, int newAvailableQuantity);
}
