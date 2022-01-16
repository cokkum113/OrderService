package com.example.order;

import com.example.order.Entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/v1/save/order/{productId}/{cnt}")
    public void saveOrder(@PathVariable Long productId,@PathVariable int cnt) {
        orderService.saveOrder(cnt, productId);
    }

    @PostMapping("/v1/save/product/{productName}/{price}")
    public Long saveProduct(@PathVariable String productName,@PathVariable int price){
        Long productsId = orderService.saveProduct(productName, price);
        return productsId;
    }

    @PostMapping("/v1/save/member/{name}")
    public void saveMember(@PathVariable("name") String name){
        orderService.saveMember(name);

    }

    @GetMapping("/v1/find/order/{orderId}")
    public Order findOrder(@PathVariable Long orderId){
        return orderService.findOrder(orderId);
    }

    @GetMapping("/v1/find/AllOrders")
    public List<Order> findOrders(){
        return orderService.findAllOrders();
    }




}
