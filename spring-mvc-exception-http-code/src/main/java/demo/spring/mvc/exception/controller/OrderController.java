package demo.spring.mvc.exception.controller;

import demo.spring.mvc.exception.domain.Order;
import demo.spring.mvc.exception.exception.OrderNotFoundException;
import demo.spring.mvc.exception.service.OrderRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping(value="/orders/{id}")
    public Order showOrder(@PathVariable("id") long id) {
        Order order = orderRepository.findOrderById(id);

        if (order == null) throw new OrderNotFoundException(id);

        return order;
    }
}
