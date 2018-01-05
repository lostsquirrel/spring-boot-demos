package demo.spring.mvc.exception.controller.advice;

import demo.spring.mvc.exception.domain.DataResult;
import demo.spring.mvc.exception.exception.DataIntegrityViolationException;
import demo.spring.mvc.exception.exception.OrderNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);

    @ResponseStatus(HttpStatus.CONFLICT)  // 409
    @ExceptionHandler(DataIntegrityViolationException.class)
    public void handleConflict(DataIntegrityViolationException e) {
        // Nothing to do
        log.debug("handle DataIntegrityViolationException {}", e.getMessage());
    }

    @ExceptionHandler(OrderNotFoundException.class)
    @ResponseBody
    public DataResult handleNotFound(OrderNotFoundException e) {
        log.debug("handle OrderNotFoundException {}", e.getMessage());
        return new DataResult(String.format("Order %s", e.getMessage()));
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public DataResult handleRuntime(RuntimeException e) {
        log.debug("handle RuntimeException {}", e.getMessage());
        return new DataResult(String.format("RuntimeException %s", e.getMessage()));
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public DataResult handleOthers(Exception e) {
        log.debug("handle Exception {}", e.getMessage());
        return new DataResult(String.format("Exception %s", e.getMessage()));
    }
}
