package edu.uptap.pos.controllers;

import edu.uptap.pos.models.Product;
import edu.uptap.pos.models.ProductBrand;
import edu.uptap.pos.models.ProductCategory;
import edu.uptap.pos.services.ProductBrandService;
import edu.uptap.pos.services.ProductCategoryService;
import edu.uptap.pos.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {

    ProductBrandService productBrandService;
    ProductCategoryService productCategoryService;
    ProductService productService;

    public ProductController(ProductService productService, ProductCategoryService productCategoryService, ProductBrandService productBrandService) {
        this.productService = productService;
        this.productCategoryService = productCategoryService;
        this.productBrandService = productBrandService;
    }

    @GetMapping
    public String getAllProducts(Model model) {
        ProductBrand productBrand = productBrandService.saveBrand(new ProductBrand("SAMSUNG", true));
        ProductCategory productCategory = productCategoryService.saveProductCategory(new ProductCategory("Smartphones", true));
        productService.saveProduct(new Product("SM-A536ELBELTM", "Galaxy A53 5G Azul Claro", "FHD+ sAMOLED 120Hz Display", 9999.00, 8499.99, 20, productBrand, productCategory));
        productService.saveProduct(new Product("SM-A528BLGMLTM", "Galaxy A52s 5G, 6GB+128 GB Verde", "Pantalla FHD+ Super AMOLED", 10499.00, 9000.00, 25, productBrand, productCategory));
        productService.saveProduct(new Product("SM-A035MZKELTM", "Galaxy A03 4+64 GB Negro", "Batería de 5,000 mAh", 3499.00, 2499.00, 54, productBrand, productCategory));
        model.addAttribute("products", productService.getProducts());
        return "product/product-list";
    }

}
