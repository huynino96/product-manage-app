package com.example.productmanage.mapper;

import com.example.productmanage.dto.ProductDTO;
import com.example.productmanage.model.Product;

public class ProductMapper {
    public static Product DtoToEntity(ProductDTO product){
        return new Product().setProductName(product.getProductName())
                .setLoyalty(product.getLoyalty()).setProductStatus(product.getProductStatus())
                .setPrice(product.getPrice()).setShippingFee(product.getShippingFee())
                .setTotalPrice(product.getTotalPrice()).setShippingCode(product.getShippingCode())
                .setOrderCode(product.getOrderCode()).setPaymentMethod(product.getPaymentMethod())
                .setDeposit(product.getDeposit()).setOrderQuantity(product.getOrderQuantity())
                .setPhone(product.getPhone()).setCustomerName(product.getCustomerName())
                .setAddress(product.getAddress()).setFbName(product.getFbName()).setFbLink(product.getFbLink())
                .setNote(product.getNote());
    }

    public static Long EntityToDto(Product product){
        return new ProductDTO().setProductName(product.getProductName())
                .setLoyalty(product.getLoyalty()).setProductStatus(product.getProductStatus())
                .setPrice(product.getPrice()).setShippingFee(product.getShippingFee())
                .setShippingCode(product.getShippingCode())
                .setOrderCode(product.getOrderCode()).setPaymentMethod(product.getPaymentMethod())
                .setDeposit(product.getDeposit()).setOrderQuantity(product.getOrderQuantity())
                .setPhone(product.getPhone()).setCustomerName(product.getCustomerName())
                .setAddress(product.getAddress()).setFbName(product.getFbName()).setFbLink(product.getFbLink())
                .setNote(product.getNote()).setTotalPrice(product.getTotalPrice());
    }
}
