package demo.spring.mvc.exception.service.impl;

import demo.spring.mvc.exception.domain.Order;
import demo.spring.mvc.exception.exception.*;
import demo.spring.mvc.exception.service.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class OrderRepositoryImpl implements OrderRepository {
    private static final Logger log = LoggerFactory.getLogger(OrderRepositoryImpl.class);

    @Override
    public Order findOrderById(long id) throws SQLException {
        Order order = new Order();
        order.setId(id);
        int _id = new Long(id).intValue();
        log.debug("got order id {}", id);
        switch (_id) {
            case 1: throw new OrderNotFoundException(id);
            case 2: throw new DataIntegrityViolationException(id);
            case 3: throw new SQLException();
            case 4: throw new DataAccessException("Error accessing database");
            case 5: throw new InvalidCreditCardException("1234123412341234");
            case 6: throw new DatabaseException("Database not found: info.db");
            case 7: throw new SupportInfoException("Custom exception occurred");
            case 8: throw new UnhandledException("Some exception occurred");
            default: log.debug("success");
        }
        return order;
    }
}
