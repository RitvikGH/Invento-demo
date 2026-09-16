package ports.IN;
import Models.Supplier;
public interface ManageSuppliersUseCase {
    Supplier registerSupplier(String name, String email);
    void linkSupplierToProduct(String supplierId, String productId);
}
