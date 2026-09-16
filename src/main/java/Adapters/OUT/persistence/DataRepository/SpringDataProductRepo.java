package Adapters.OUT.persistence.DataRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Adapters.OUT.persistence.Entity.ProductJpaEntity;

@Repository 
public interface SpringDataProductRepo extends JpaRepository<ProductJpaEntity, String>{

}
