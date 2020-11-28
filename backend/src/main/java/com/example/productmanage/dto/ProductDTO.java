package com.example.productmanage.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class ProductDTO {
    @NotBlank(message = "ProductName is required")
    private String productName;
    private String loyalty;
    private String productStatus;
    private Long price;
    private Long shippingFee;
    private Long totalPrice;
    private String shippingCode;
    private String orderCode;
    private String paymentMethod;
    private Long deposit;
    private int orderQuantity;
    private int phone;
    private String customerName;
    private String address;
    private String fbName;
    private String fbLink;
    private String note;
}
