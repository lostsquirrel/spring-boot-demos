package demo.spring.mvc.exception.service;

import demo.spring.mvc.exception.domain.Order;

public interface OrderRepository {
    Order findOrderById(long id);
}
