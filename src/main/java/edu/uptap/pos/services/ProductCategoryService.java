package edu.uptap.pos.services;

import edu.uptap.pos.models.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    ProductCategory saveProductCategory(ProductCategory category);
    List<ProductCategory> getProductCategories();
    ProductCategory getProductCategoryByName(String categoryName);
}
