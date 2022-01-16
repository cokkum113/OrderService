package com.example.order;

import com.example.order.Entity.Member;
import com.example.order.Entity.Orders;
import com.example.order.Entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ProductRepository productRepository;
    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;

    @Transactional
    public Long saveProduct(String productName, int price){
        Product product = new Product();
        product.setProductName(productName);
        product.setPrice(price);
        productRepository.save(product);
        return product.getId();
    }
    @Transactional
    public Long saveMember(String name){
        Member member = new Member();
        member.setName(name);
        memberRepository.save(member);
        return member.getId();
    }

    @Transactional
    public void saveOrder(int cnt, Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        Orders order = new Orders().builder()
                .product(product.get())
                .productCnt(cnt)
                .build();
        orderRepository.save(order);

    }

    @Transactional
    public Orders findOrder(Long orderId){
        Optional<Orders> order = orderRepository.findById(orderId);
        return order.get();
    }

    @Transactional
    public List<Orders> findAllOrders(){
        return orderRepository.findAll();
    }


}
