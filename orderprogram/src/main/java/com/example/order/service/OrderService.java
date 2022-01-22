package com.example.order.service;

import com.example.order.Entity.Member;
import com.example.order.Entity.Orders;
import com.example.order.Entity.Product;
import com.example.order.MemberRepository;
import com.example.order.OrderRepository;
import com.example.order.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ProductRepository productRepository;
    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;

    @Transactional
    public Product createProduct(String productName, int price) {
        Product product = Product.createProduct(price, productName);
        return productRepository.save(product);
    }


    @Transactional
    public Member createMember(String name) {
        Member member = Member.createMember(name);
        return memberRepository.save(member);
    }

    @Transactional
    public Orders order(int cnt, String productName) {
        Product product = productRepository.findByProductName(productName).orElseThrow(RuntimeException::new);
        Orders orders = Orders.createOrder(product, cnt);
        orderRepository.save(orders);
        return orders;
    }

    @Transactional
    public Orders findOrder(Long orderId) {
        Orders order = orderRepository.findById(orderId).orElseThrow(RuntimeException::new);
        return order;
    }

    @Transactional
    public List<Orders> findAllOrders() {
        return orderRepository.findAll();
    }


}
