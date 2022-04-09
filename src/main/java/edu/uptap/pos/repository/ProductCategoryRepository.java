package edu.uptap.pos.repository;

import edu.uptap.pos.models.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
    ProductCategory findProductCategoryByCategoryName(String categoryName);
}
