package edu.uptap.pos.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table
@Data
public class ProductCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_category_id", nullable = false)
    private Long productCategoryId;

    @Column(name = "category_name", nullable = false, unique = true)
    private String categoryName;

}
