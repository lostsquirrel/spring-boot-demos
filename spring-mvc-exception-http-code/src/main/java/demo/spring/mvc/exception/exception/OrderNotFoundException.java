package demo.spring.mvc.exception.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such order")
public class OrderNotFoundException extends RuntimeException {

    /**
     * Unique ID for Serialized object
     */
    private static final long serialVersionUID = -8790211652911971729L;

    public OrderNotFoundException(Long orderId) {
        super(orderId + " not found");
    }
}

