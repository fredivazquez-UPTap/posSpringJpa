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
import java.io.Serializable;

@Entity
@Table(name = "payment_methods")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class PaymentMethod implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_method_id")
    private Long paymentMethodId;

    @Column(name = "payment_name", nullable = false)
    private String paymentName;

    @Column(name = "payment_description")
    private String paymentDescription;

    @Column(name = "status", nullable = false)
    private boolean status;
}
