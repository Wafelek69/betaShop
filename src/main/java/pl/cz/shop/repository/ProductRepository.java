package pl.cz.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cz.shop.entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
