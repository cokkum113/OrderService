package com.example.order.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@Table(name = "order")
@NoArgsConstructor
@AllArgsConstructor
public class Order {

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

//    private int total = 1;

    private int productCnt;

}
