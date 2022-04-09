package edu.uptap.pos.services;

import edu.uptap.pos.exceptions.PosException;
import edu.uptap.pos.models.Product;
import edu.uptap.pos.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product newProduct, Long id) {
        return productRepository.findById(id).map(product -> {
            product.setProductCode(newProduct.getProductCode());
            product.setProductCategory(newProduct.getProductCategory());
            product.setProductBrand(newProduct.getProductBrand());
            product.setProductName(newProduct.getProductName());
            product.setProductDescription(newProduct.getProductDescription());
            product.setPriceBuy(newProduct.getPriceBuy());
            product.setPriceSell(newProduct.getPriceSell());
            product.setUnitsInStock(newProduct.getUnitsInStock());
            product.setStatus(newProduct.getStatus());
            return productRepository.save(product);
        }).orElseGet(() -> productRepository.save(newProduct));
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new PosException(id));
    }

    @Override
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }
}
