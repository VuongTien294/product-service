package tien.baseproject.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tien.baseproject.productservice.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
