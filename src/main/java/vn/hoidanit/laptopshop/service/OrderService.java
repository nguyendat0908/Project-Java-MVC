package vn.hoidanit.laptopshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.Order;
import vn.hoidanit.laptopshop.domain.OrderDetail;
import vn.hoidanit.laptopshop.repository.OrderDetailRepository;
import vn.hoidanit.laptopshop.repository.OrderRepository;

@Service
public class OrderService {

    // Dependency Injection
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;

    public OrderService(OrderRepository orderRepository, OrderDetailRepository orderDetailRepository){
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
    }

    public List<Order> getAllOrders(){
        return this.orderRepository.findAll();
    }

    public Optional<Order> getOrderById(long id){
        return this.orderRepository.findById(id);
    }

    public void deleteOrderById(long id){

        // Delete OrderDetail
        Optional<Order> order = this.getOrderById(id);

        if (order.isPresent()) {
            Order currentOrder = order.get();

            List<OrderDetail> orderDetails = currentOrder.getOrderDetails();
            for (OrderDetail orderDetail : orderDetails) {
                this.orderDetailRepository.deleteById(orderDetail.getId());
            }
        }
        this.orderRepository.deleteById(id);
    }

    public void updateOrder(Order order){

        Optional<Order> orderOptional = this.getOrderById(order.getId());
        if (orderOptional.isPresent()) {
            Order currentOrder = orderOptional.get();

            currentOrder.setStatus(order.getStatus());
            this.orderRepository.save(currentOrder);
        }
    }
}
