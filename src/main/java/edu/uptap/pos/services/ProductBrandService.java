package edu.uptap.pos.services;

import edu.uptap.pos.models.ProductBrand;

import java.util.List;

public interface ProductBrandService {
    ProductBrand saveBrand(ProductBrand productBrand);
    List<ProductBrand> getProductBrands();
}
