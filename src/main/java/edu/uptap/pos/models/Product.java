package edu.uptap.pos.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "products")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "product_code", nullable = false, unique = true)
    private String productCode;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "price_sell")
    private Double priceSell;

    @Column(name = "price_buy")
    private Double priceBuy;

    @Column(name = "units_in_stock", nullable = false)
    private int unitsInStock;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "product_brand_id")
    private ProductBrand productBrand;

    @ManyToOne
    @JoinColumn(name = "product_category_id")
    private ProductCategory productCategory;

    public Product(String productCode, String productName, String productDescription, Double priceSell, Double priceBuy, int unitsInStock, ProductBrand productBrand, ProductCategory productCategory) {
        this.productCode = productCode;
        this.productName = productName;
        this.productDescription = productDescription;
        this.priceSell = priceSell;
        this.priceBuy = priceBuy;
        this.unitsInStock = unitsInStock;
        this.productBrand = productBrand;
        this.productCategory = productCategory;
    }
}
