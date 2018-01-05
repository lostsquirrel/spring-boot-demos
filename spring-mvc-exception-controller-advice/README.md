## handle global exception by `@ControllerAdvice`
**request mapping and exception handler must be in same controller**

1. OrderNotFoundException

    ```sh
    curl  'http://127.0.0.1:8080/orders/1' -H "Content-Type: application/json"
    ```
    ```json
    {
        "timestamp": 1515121948267,
        "status": 404,
        "error": "Not Found",
        "exception": "demo.spring.mvc.exception.exception.OrderNotFoundException",
        "message": "1 not found",
        "path": "/orders/1"
    }
    ```

2. DataIntegrityViolationException

    ```sh
    curl -sI 'http://127.0.0.1:8080/orders/2' -H "Content-Type: application/json"
    ```
    ```
    HTTP/1.1 409
    Content-Length: 0
    Date: Fri, 05 Jan 2018 03:24:28 GMT

    ```

3. SQLException with custom response
    ```sh
    curl  'http://127.0.0.1:8080/orders/3' -H "Content-Type: application/json"
    ```
    ```json
    {
        "status": 1,
        "message": "Exception null",
        "data": null
    }
    ```
4. DataAccessException with custom response
    ```sh
    curl  'http://127.0.0.1:8080/orders/4' -H "Content-Type: application/json"
    ```
    ```json
    {
        "status": 1,
        "message": "RuntimeException Error accessing database",
        "data": null
    }
    ```

5. success request
    ```sh
    curl  'http://127.0.0.1:8080/orders/9' -H "Content-Type: application/json"
    ```
    ```json
    {
        "id": 9
    }
    ```