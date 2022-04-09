package edu.uptap.pos.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@Entity
@Table(name = "brands")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class ProductBrand implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_brand_id", nullable = false)
    private Long productBrandId;

    @Column(name = "brand_name", nullable = false)
    private String brandName;

    @Column(name = "status", nullable = false)
    private boolean status;

    public ProductBrand(String brandName, boolean status) {
        this.brandName = brandName;
        this.status = status;
    }


}
