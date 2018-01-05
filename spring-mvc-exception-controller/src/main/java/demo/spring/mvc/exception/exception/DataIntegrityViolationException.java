package demo.spring.mvc.exception.exception;

public class DataIntegrityViolationException extends RuntimeException {
    public DataIntegrityViolationException(Long orderId) {
        super(orderId + " Integrity Violation");
    }
}
