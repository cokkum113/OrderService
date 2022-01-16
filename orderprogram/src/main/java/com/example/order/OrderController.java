package com.example.order;

import com.example.order.Entity.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    private OrderService orderService;

    @PostMapping("/v1/save/order/{memeberId}/{productId/{cnt}")
    private Long saveOrder(@PathVariable Long memberId, @PathVariable Long productId, @PathVariable int cnt){
        Long orderId = orderService.makeOrder(memberId, productId, cnt);
        return orderId;
    }

    @PostMapping("v1/save/product/{productName}/{price}")
    private Long saveProduct(@PathVariable String productName,@PathVariable int price){
        Long productsId = orderService.saveProduct(productName, price);
        return productsId;
    }

    @PostMapping("v1/save/member/{name}")
    private Long saveMember(@PathVariable String name){
        Long memberId = orderService.saveMember(name);
        return memberId;
    }

    @GetMapping("v1/find/order/{orderId}")
    private Order findOrder(@PathVariable Long orderId){
        return orderService.findOrder(orderId);
    }

    @GetMapping("v1/find/AllOrders")
    private List<Order> findOrders(){
        return orderService.findAllOrders();
    }




}
