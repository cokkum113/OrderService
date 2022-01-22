package com.example.order;

import com.example.order.Entity.Member;
import com.example.order.Entity.Orders;
import com.example.order.Entity.Product;
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
         Product product = orderService.createProduct(
                        productRequest.getProductName(),
                        productRequest.getPrice());
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProductId(product.getId());
        productResponse.setProductName(product.getProductName());
        productResponse.setPrice(product.getPrice());
        return productResponse;
    }

    @PostMapping("/v1/member")
    public MemberRes saveMember(@Valid @RequestBody MemberReq memberReq) {
        Member member = orderService.createMember(memberReq.getName());
        MemberRes memberRes = new MemberRes();
        memberRes.setMemberId(member.getId());
        memberRes.setName(member.getName());
        return memberRes;
    }

    @PostMapping("/v1/order")
    public OrderResponse saveOrder(@RequestBody OrderRequest orderRequest) {
         Orders orders = orderService.order(orderRequest.getProductCnt(),
                orderRequest.getProductName());

        return new OrderResponse(
                orders.getId(),
                orders.getProduct().getProductName(),
                orders.getProductCnt(),
                orders.getTotal()
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
