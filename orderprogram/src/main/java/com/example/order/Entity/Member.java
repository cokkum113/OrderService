package com.example.order.Entity;

import com.example.order.dto.OrderResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "memeber")
public class Member {
    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Member(String name){
        this.name = name;
    }

    public static Member createMember(String name) {
        return new Member(name);
    }

//    @OneToMany(mappedBy = "member")
//    private List<Orders> orders = new ArrayList<>();

//    public void addOrder(Orders order){
//        if (this.orders.contains(order)) {
//            return;
//        }
//        this.orders.add(order);
//        order.setMember(this);
//    }


}
