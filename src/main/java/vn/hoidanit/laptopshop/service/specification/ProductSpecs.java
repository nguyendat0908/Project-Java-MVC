package vn.hoidanit.laptopshop.service.specification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.domain.Product_;

public class ProductSpecs {
    
    // Viết truy vấn bằng Specification
    /*
        Root: đại diện table muốn truy vấn, được dùng để truy cập entity và fields của nó
        CriteriaQuery: tạo ra cấu trúc tổng quan của query, dùng để modify the select, join,group by, order by, etc. (ít dùng)
        CriteriaBuilder: sử dụng predicates, để build ra điều kiện của câu query
     */
    public static Specification<Product> nameLike(String name){
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Product_.NAME), "%" + name + "%");
    }

    // Truy vấn lấy ra giá trị tối thiểu
    public static Specification<Product> minPrice(double price){
        return (root, query, criteriaBuilder) -> criteriaBuilder.ge(root.get(Product_.PRICE), price);
    }

    // Truy vấn lấy ra giá trị tối đa
    public static Specification<Product> maxPrice(double price){
        return (root, query, criteriaBuilder) -> criteriaBuilder.le(root.get(Product_.PRICE), price);
    }

    // Truy vấn lấy ra sản phẩm có hãng sản xuất là APPLE
    public static Specification<Product> factoryQuery(String factory){
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Product_.FACTORY), factory);
    }
}
