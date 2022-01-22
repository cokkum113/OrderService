package com.example.order.service;

import com.example.order.Entity.Orders;
import com.example.order.Entity.Product;
import com.example.order.MemberRepository;
import com.example.order.OrderRepository;
import com.example.order.ProductRepository;
import com.example.order.model.MemberModel;
import com.example.order.model.ProductModel;
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
    public ProductModel createProduct(String productName, int price) {
        ProductModel product = ProductModel.createProduct(productName, price);

        return ProductModel.valueOf(
                productRepository.save(product.toEntity())
        );
    }


    @Transactional
    public MemberModel createMember(String name) {
        MemberModel member = MemberModel.createMember(name);
        return MemberModel.valueOf(
                memberRepository.save(member.toEntity())
        );
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
