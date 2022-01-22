//package com.example.order.model;
//
//import com.example.order.Entity.Product;
//import com.example.order.dto.ProductResponse;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
//public class ProductModel {
//    private Long productId;
//    private String productName;
//    private int price;
//
//    public static ProductModel createProduct(String productName, int price) {
//        ProductModel model = new ProductModel();
//        model.price = price;
//        model.productName = productName;
//        return model;
//    }
//
//    public ProductResponse toResponse() {
//        return new ProductResponse(
//                productId,
//                productName,
//                price,
//                total
//        );
//    }
//
//    public Product toEntity() {
//        return Product.createProduct(price, productName);
//    }
//
//    public static ProductModel valueOf(Product product) {
//        return new ProductModel(
//                product.getId(),
//                product.getProductName(),
//                product.getPrice()
//        );
//    }
//}
