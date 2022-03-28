package edu.uptap.pos.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.io.Serializable;

@Entity
@Table(name = "order_lines")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class OrderLine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_line_id")
    private Long orderLineId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "unit_price", nullable = false)
    private double unitPrice;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "sub_total", nullable = false)
    private double subTotal;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

}
