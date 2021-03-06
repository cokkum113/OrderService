package com.example.order.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "member_id")
//    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    private int total;

    private int productCnt;

    public void setProduct(Product product) {
        this.product = product;
        product.addOrder(this);
    }

    public static Orders createOrder(Product product, int productCnt) {
        Orders orders = new Orders();
        orders.setProduct(product);
        orders.productCnt = productCnt;
        orders.total = (product.getPrice() * productCnt);
        return orders;
    }

}
