package com.example.order.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderRequest {
    private String userName;
    private String productName;
    private int productCnt;

    @Builder
    public OrderRequest(String userName, String productName, int productCnt) {
        this.userName = userName;
        this.productName = productName;
        this.productCnt = productCnt;
    }
}
