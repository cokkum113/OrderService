package com.example.order.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aspectj.weaver.ast.Or;
import org.hibernate.criterion.Order;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@Getter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    private String productName;

    private int price;

    @OneToMany(mappedBy = "product")
    private List<Orders> orders = new ArrayList<>();

    //편의메소드
    public void addOrder(Orders orders) {
        if (this.orders.contains(orders)) {
            return;
        }
        this.orders.add(orders);
        orders.setProduct(this);
    }
    public static Product createProduct(int price, String productName) {
        Product product = new Product();
        product.price = price;
        product.productName = productName;

        return product;
    }


}
