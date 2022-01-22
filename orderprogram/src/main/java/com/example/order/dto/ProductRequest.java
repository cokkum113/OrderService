package com.example.order.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Builder
public class ProductRequest {
    @NotNull
    private String productName;
    @NotNull
    private Integer price;
}
