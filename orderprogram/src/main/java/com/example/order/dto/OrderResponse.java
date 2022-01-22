package com.example.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class OrderResponse {
    private Long id;
//    private String userName;
    private String product;
    private int productCnt;
//    private int total;

}
