//package com.example.order.model;
//
//import com.example.order.Entity.Orders;
//import com.example.order.Entity.Product;
//import com.example.order.ProductRepository;
//import com.example.order.dto.OrderResponse;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import java.util.Optional;
//
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
//public class OrderModel {
//
//    private ProductRepository productRepository;
//    private Long orderId;
////    private String userName;
//
//    private String productName;
//    private int productCnt;
////    private int total;
//
//    public Product mappingProduct(String productName) {
//        Optional<Product> product = productRepository.findByProductName(productName);
//        return product.get();
//    }
//
//    public static OrderModel createOrder(String productName, int productCnt) {
//        OrderModel order = new OrderModel();
//        order.productName = productName;
//        order.productCnt = productCnt;
////        order.total = total;
//        return order;
//    }
//    public OrderResponse toResponse() {
//        return new OrderResponse(
//                orderId,
//                productName,
//                productCnt
//        );
//    }
//
//    public Orders toEntity() {
//        return Orders.createOrder(, productCnt);
//    }
//}
