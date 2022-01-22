package com.example.order;

import com.example.order.Entity.Orders;
import com.example.order.dto.*;
import com.example.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/v1/product")
    public ProductResponse saveProduct(@Valid @RequestBody ProductRequest productRequest) {
        return orderService.createProduct(
                        productRequest.getProductName(),
                        productRequest.getPrice()
                ).toResponse();
    }

    @PostMapping("/v1/member")
    public MemberRes saveMember(@Valid @RequestBody MemberReq memberReq) {
        return orderService.createMember(
                memberReq.getName()
        ).toResponse();
    }

    @PostMapping("/v1/order")
    public OrderResponse saveOrder(@RequestBody OrderRequest orderRequest) {
         Orders orders = orderService.order(orderRequest.getProductCnt(),
                orderRequest.getProductName());

        return new OrderResponse(
                orders.getId(),
                orders.getProduct().getProductName(),
                orders.getProductCnt()
        );


    }

    @GetMapping("/v1/order/{orderId}")
    public Orders findOrder(@PathVariable Long orderId){
        return orderService.findOrder(orderId);
    }

    @GetMapping("/v1/order")
    public List<Orders> findOrders(){
        return orderService.findAllOrders();
    }




}
