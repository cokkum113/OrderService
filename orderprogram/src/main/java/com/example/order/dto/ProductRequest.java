package com.example.order.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

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
