package com.example.productmanage.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "products")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private Date purchaseTime;

    @Column
    private String loyalty;

    @Column
    private String productStatus;

    @Column
    private Long price;

    @Column
    private Long shippingFee;

    @Column
    private Long totalPrice;

    @Column
    private String shippingCode;

    @Column
    private String orderCode;

    @Column
    private String paymentMethod;

    @Column
    private Long deposit;

    @Column
    private int orderQuantity;

    @Column
    private int phone;

    @Column
    private String customerName;

    @Column
    private String address;

    @Column
    private String fbName;

    @Column
    private String fbLink;

    @Column
    private String note;

}
