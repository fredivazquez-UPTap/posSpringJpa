package edu.uptap.pos.services;

import edu.uptap.pos.models.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
    Product updateProduct(Product newProduct, Long id);
    List<Product> getProducts();
    Product getProduct(Long id);
}
