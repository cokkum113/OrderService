package com.example.order.dto;

import com.example.order.Entity.Orders;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class OrderResponse {
    private Long id;
    private String name;
    private String product;
    private int productCnt;
    private int total;

}
