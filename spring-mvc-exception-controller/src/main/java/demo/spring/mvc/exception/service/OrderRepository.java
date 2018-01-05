package demo.spring.mvc.exception.service;

import demo.spring.mvc.exception.domain.Order;

import java.sql.SQLException;

public interface OrderRepository {
    Order findOrderById(long id) throws SQLException;
}
