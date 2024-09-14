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
     * Root: đại diện table muốn truy vấn, được dùng để truy cập entity và fields
     * của nó
     * CriteriaQuery: tạo ra cấu trúc tổng quan của query, dùng để modify the
     * select, join,group by, order by, etc. (ít dùng)
     * CriteriaBuilder: sử dụng predicates, để build ra điều kiện của câu query
     */
    public static Specification<Product> nameLike(String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Product_.NAME), "%" + name + "%");
    }

    // Truy vấn lấy ra giá trị tối thiểu
    public static Specification<Product> minPrice(double price) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.ge(root.get(Product_.PRICE), price);
    }

    // Truy vấn lấy ra giá trị tối đa
    public static Specification<Product> maxPrice(double price) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.le(root.get(Product_.PRICE), price);
    }

    // Truy vấn lấy ra sản phẩm có hãng sản xuất với một điều kiện
    public static Specification<Product> matchFactory(String factory) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Product_.FACTORY), factory);
    }

    // Truy vấn lấy ra sản phẩm với nhiều hãng sản xuất
    public static Specification<Product> matchListFactory(List<String> factory){
        return (root, query, criteriaBuilder) -> criteriaBuilder.in(root.get(Product_.FACTORY)).value(factory);
    }

    // Truy vấn lấy ra sản phẩm có mục đích với một điều kiện
    public static Specification<Product> matchTarget(String target) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Product_.target), target);
    }

    // Truy vấn lấy ra sản phẩm với nhiều mục đích
    public static Specification<Product> matchListTarget(List<String> target){
        return (root, query, criteriaBuilder) -> criteriaBuilder.in(root.get(Product_.TARGET)).value(target);
    }

    // Truy vấn lấy ra sản phẩm với điều kiện giá trong khoảng
    public static Specification<Product> matchPrice(double min, double max){
        return (root, query, criteriaBuilder) -> criteriaBuilder.and(
            criteriaBuilder.gt(root.get(Product_.PRICE), min),
            criteriaBuilder.le(root.get(Product_.PRICE), max)
        );
    }

    // Truy vấn lấy ra sản phẩm với nhiều điều kiện giá trong khoảng
    public static Specification<Product> matchMultiplePrice(double min, double max){
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get(Product_.PRICE), min, max);
    }
}
