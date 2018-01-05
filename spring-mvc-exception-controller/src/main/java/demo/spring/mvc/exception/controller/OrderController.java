package demo.spring.mvc.exception.controller;

import demo.spring.mvc.exception.domain.DataResult;
import demo.spring.mvc.exception.domain.Order;
import demo.spring.mvc.exception.exception.DataAccessException;
import demo.spring.mvc.exception.exception.DataIntegrityViolationException;
import demo.spring.mvc.exception.exception.OrderNotFoundException;
import demo.spring.mvc.exception.exception.SupportInfoException;
import demo.spring.mvc.exception.service.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@RestController
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping(value="/orders/{id}")
    public Order showOrder(@PathVariable("id") long id) throws SQLException {
        Order order = orderRepository.findOrderById(id);
        return order;
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such order")
    @ExceptionHandler(OrderNotFoundException.class)
    public void orderNotFound(Exception exception) {
        log.error("order {}", exception.getMessage());
    }

    /**
     * Convert a predefined exception to an HTTP Status code
     */
    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "Data integrity violation") // 409
    @ExceptionHandler(DataIntegrityViolationException.class)
    public void conflict() {
        log.error("Request raised a DataIntegrityViolationException");
        // Nothing to do
    }



    @ExceptionHandler({ SQLException.class, DataAccessException.class })
    public DataResult databaseError(Exception exception) {
        // Nothing to do. Return value 'databaseError' used as logical view name
        log.error("Request raised " + exception.getClass().getSimpleName());
        return new DataResult("databaseError");
    }

    @ExceptionHandler(SupportInfoException.class)
    public DataResult handleSupportInfoException(HttpServletRequest req, Exception exception) {
        log.error(exception.getClass().getSimpleName());
        return new DataResult(exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public DataResult handleOtherError(HttpServletRequest req, Exception exception) {
        log.error("Request raised " + exception.getClass().getSimpleName());
        return new DataResult(exception.getMessage());
    }
}
