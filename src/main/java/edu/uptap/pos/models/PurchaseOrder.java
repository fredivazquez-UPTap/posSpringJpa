package edu.uptap.pos.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "purchase_orders")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class PurchaseOrder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "purchase_order_id")
    private Long purchaseOrderId;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private double totalAmount;

    @Column(nullable = false)
    private Date orderDate;

    @OneToMany(mappedBy = "purchaseOrder", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<PurchaseOrderLine> orderLines;

}
