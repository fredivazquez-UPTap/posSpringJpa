package edu.uptap.pos.views;

import edu.uptap.pos.models.Product;
import edu.uptap.pos.models.ProductBrand;
import edu.uptap.pos.models.ProductCategory;
import edu.uptap.pos.models.Status;
import edu.uptap.pos.services.ProductBrandService;
import edu.uptap.pos.services.ProductCategoryService;
import edu.uptap.pos.services.ProductService;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import org.primefaces.util.LangUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ManagedBean
@Component
@ViewScoped
public class ProductView implements Serializable {

    private List<Product> products;
    private List<ProductCategory> productCategories;
    private List<ProductBrand> productBrands;
    private Status[] statuses;
    private Product selectedProduct;
    private List<Product> selectedProducts;
    private List<Product> filteredProducts;
    private final ProductService productService;
    private final ProductCategoryService productCategoryService;
    private final ProductBrandService productBrandService;

    ProductView (ProductService productService, ProductCategoryService productCategoryService, ProductBrandService productBrandService) {
        this.productService = productService;
        this.productCategoryService = productCategoryService;
        this.productBrandService = productBrandService;
    }

    public boolean globalFilterFunction(Object value, Object filter) {
        String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();
        if (LangUtils.isBlank(filterText)) {
            return true;
        }
        Product product = (Product) value;
        return product.getProductCode().toLowerCase().contains(filterText)
                || product.getProductBrand().getBrandName().toLowerCase().contains(filterText)
                || product.getPriceBuy().toString().toLowerCase().contains(filterText)
                || product.getPriceSell().toString().toLowerCase().contains(filterText)
                || product.getProductCategory().getCategoryName().toLowerCase().contains(filterText);
    }

    @PostConstruct
    public void init() {
        this.products = this.productService.getProducts();
        this.productCategories = this.productCategoryService.getProductCategories();
        this.productBrands = this.productBrandService.getProductBrands();
        this.statuses = Status.values();
    }

    public void openNew() {
        this.selectedProduct = new Product();
        PrimeFaces.current().ajax().update("form:manage-product-content");
    }

    public void saveProduct() {
        Product product;
        if (this.selectedProduct.getProductId() == null) {
            product = this.productService.saveProduct(selectedProduct);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Added", product.toString()));
        } else {
            product = this.productService.updateProduct(selectedProduct, selectedProduct.getProductId());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Updated", product.toString()));
        }
        this.products = this.productService.getProducts();
        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public void deleteProduct() {
        this.productService.deleteProduct(selectedProduct);
        this.products.remove(this.selectedProduct);
        this.selectedProduct = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public String statusSeverity(Status status) {
        String result = "success";
        switch (status) {
            case IN_STOCK -> result = "success";
            case LOW_STOCK -> result = "warning";
            case OUT_OF_STOCK -> result = "danger";
        }
        return result;
    }

    public List<Product> getProducts() {
        return this.productService.getProducts();
    }

    public List<ProductBrand> getProductBrands() {
        return this.productBrandService.getProductBrands();
    }

    public List<ProductCategory> getProductCategories() {
        return this.productCategoryService.getProductCategories();
    }

    public Status[] getStatuses() {
        return Status.values();
    }

}
