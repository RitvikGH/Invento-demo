package ports.OUT;
import java.util.Optional;

import Models.Supplier;

public interface SupplierRepositoryPort {
    Optional<Supplier> findById(String id);
    void save(Supplier supplier);

}
