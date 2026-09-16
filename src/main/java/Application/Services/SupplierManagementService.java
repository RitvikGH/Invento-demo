package Application.Services;

import java.util.UUID;

import Exceptions.SupplierNotFoundException;
import Models.Product;
import Models.Supplier;
import ports.IN.ManageSuppliersUseCase;
import ports.OUT.ProductRepositoryPort;
import ports.OUT.SupplierRepositoryPort;

public class SupplierManagementService implements ManageSuppliersUseCase {
    private final SupplierRepositoryPort supplierRepository;
    private final ProductRepositoryPort productRepository;

    public SupplierManagementService(SupplierRepositoryPort supplierRepository, 
                                     ProductRepositoryPort productRepository) {
        this.supplierRepository = supplierRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Supplier registerSupplier(String name, String email) {
        Supplier newSupplier = new Supplier(UUID.randomUUID().toString(), name, email);
        supplierRepository.save(newSupplier);
        return newSupplier;
    }

    @Override
    public void linkSupplierToProduct(String supplierId, String productId) {
        Supplier supplier = supplierRepository.findById(supplierId)
            .orElseThrow(() -> new SupplierNotFoundException(supplierId));

        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new IllegalArgumentException("Unknown Product ID: " + productId));

        // Reconstruct product with the new supplier link
        Product updatedProduct = new Product(
            product.getProdName(),
            product.getProdID(), 
            product.getSKU(), 
            supplier.getSupplierID(), 
            product.getStockQuantity()
        );
        
        productRepository.save(updatedProduct);
    }

}
