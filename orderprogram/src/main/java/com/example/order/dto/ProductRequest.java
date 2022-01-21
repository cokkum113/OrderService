package com.example.order.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
public class ProductRequest {
    private String productName;
    private int price;

    @Builder
    public ProductRequest(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }


}
