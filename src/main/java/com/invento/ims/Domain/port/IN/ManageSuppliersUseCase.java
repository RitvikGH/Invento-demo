package com.invento.ims.Domain.port.IN;
import com.invento.ims.Domain.Models.Supplier;
public interface ManageSuppliersUseCase {
    Supplier registerSupplier(String name, String email);
    void linkSupplierToProduct(String supplierId, String productId);
}
