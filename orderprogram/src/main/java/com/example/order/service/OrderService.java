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
    public Long createProduct(String productName, int price) {
        Product product = Product.createProduct(price, productName);
        productRepository.save(product);
        return product.getId();
    }

    @Transactional
    public Long createMember(String name) {
        Member member = Member.createMember(name);
        memberRepository.save(member);
        return member.getId();
    }

    @Transactional
    public void order(int cnt, Long productId, Long memberId) {
        Product product = productRepository.findById(productId).orElseThrow(RuntimeException::new);
        Member member = memberRepository.findById(memberId).orElseThrow(RuntimeException::new);
        Orders orders = Orders.createOrder(product,member,cnt);
        orderRepository.save(orders);
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
