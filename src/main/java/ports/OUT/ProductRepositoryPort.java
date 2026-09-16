package ports.OUT;
import java.util.Optional;

import Models.Product;
public interface ProductRepositoryPort {
    Optional<Product> findById(String id);
    void save(Product product);
}
