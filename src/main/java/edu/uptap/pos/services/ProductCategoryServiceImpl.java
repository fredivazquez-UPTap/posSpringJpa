package edu.uptap.pos.services;

import edu.uptap.pos.models.ProductCategory;
import edu.uptap.pos.repository.ProductCategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository repository;

    ProductCategoryServiceImpl(ProductCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductCategory saveProductCategory(ProductCategory category) {
        return repository.save(category);
    }
}
