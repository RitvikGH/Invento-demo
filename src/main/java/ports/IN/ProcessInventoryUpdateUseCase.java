package ports.IN;

public interface ProcessInventoryUpdateUseCase {
    void processUpdate(String productId, int newAvailableQuantity);
}
