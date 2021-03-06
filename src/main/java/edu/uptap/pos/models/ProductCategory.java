package edu.uptap.pos.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "product_categories")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class ProductCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_category_id", nullable = false)
    private Long productCategoryId;

    @Column(name = "category_name", nullable = false, unique = true)
    private String categoryName;

    @Column(name = "status", nullable = false)
    private boolean status;

    public ProductCategory(String categoryName, boolean status) {
        this.categoryName = categoryName;
        this.status = status;
    }
}
