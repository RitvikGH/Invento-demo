package com.invento.ims.application.services;

import java.util.UUID;

import com.invento.ims.Domain.Models.Product;
import com.invento.ims.Domain.Models.Supplier;
import com.invento.ims.Domain.port.IN.ManageSuppliersUseCase;
import com.invento.ims.Domain.port.OUT.ProductRepositoryPort;
import com.invento.ims.Domain.port.OUT.SupplierRepositoryPort;
import com.invento.ims.Exceptions.SupplierNotFoundException;

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
