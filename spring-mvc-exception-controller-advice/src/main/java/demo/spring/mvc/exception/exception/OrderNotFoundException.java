package demo.spring.mvc.exception.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class OrderNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -8790211652911971729L;

    public OrderNotFoundException(Long orderId) {
        super(orderId + " not found");
    }
}

