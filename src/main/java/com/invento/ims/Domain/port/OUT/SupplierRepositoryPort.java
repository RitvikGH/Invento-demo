package com.invento.ims.Domain.port.OUT;
import java.util.Optional;

import com.invento.ims.Domain.Models.Supplier;

public interface SupplierRepositoryPort {
    Optional<Supplier> findById(String id);
    void save(Supplier supplier);

}
