package demo.spring.mvc.exception.service.impl;

import demo.spring.mvc.exception.domain.Order;
import demo.spring.mvc.exception.service.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderRepositoryImpl implements OrderRepository {
    @Override
    public Order findOrderById(long id) {
        return null;
    }
}
