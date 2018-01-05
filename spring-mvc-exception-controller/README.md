## handle exception in same controller
**request mapping and exception handler must be in same controller**

1. OrderNotFoundException

    ```sh
    curl  'http://127.0.0.1:8080/order/1' -H "Content-Type: application/json"
    ```
    ```json
    {
        "timestamp": 1515119408685,
        "status": 404,
        "error": "Not Found",
        "exception": "demo.spring.mvc.exception.exception.OrderNotFoundException",
        "message": "No such order",
        "path": "/orders/1"
    }
    ```

2. DataIntegrityViolationException

    ```sh
    curl  'http://127.0.0.1:8080/order/2' -H "Content-Type: application/json"
    ```
    ```json
    {
        "timestamp": 1515119496131,
        "status": 409,
        "error": "Conflict",
        "exception": "demo.spring.mvc.exception.exception.DataIntegrityViolationException",
        "message": "Data integrity violation",
        "path": "/orders/2"
    }
    ```

3. SQLException with custom response
    ```sh
    curl  'http://127.0.0.1:8080/order/3' -H "Content-Type: application/json"
    ```
    ```json
    {
        "status": 1,
        "message": "databaseError",
        "data": null
    }
    ```
4. DataAccessException with custom response
    ```sh
    curl  'http://127.0.0.1:8080/order/4' -H "Content-Type: application/json"
    ```
    ```json
    {
        "status": 1,
        "message": "databaseError",
        "data": null
    }
    ```
5. InvalidCreditCardException with custom response
    ```sh
    curl  'http://127.0.0.1:8080/order/5' -H "Content-Type: application/json"
    ```
    ```json
    {
        "status": 1,
        "message": "1234123412341234",
        "data": null
    }
    ```
6. DatabaseException with custom response
    ```sh
    curl  'http://127.0.0.1:8080/order/6' -H "Content-Type: application/json"
    ```
    ```json
    {
        "status": 1,
        "message": "Database not found: info.db",
        "data": null
    }
    ```
7. SupportInfoException with custom response
    ```sh
    curl  'http://127.0.0.1:8080/order/7' -H "Content-Type: application/json"
    ```
    ```json
    {
        "status": 1,
        "message": "Custom exception occurred",
        "data": null
    }
    ```
8. UnhandledException with custom response
    ```sh
    curl  'http://127.0.0.1:8080/order/8' -H "Content-Type: application/json"
    ```
    ```json
    {
        "status": 1,
        "message": "Some exception occurred",
        "data": null
    }
    ```
9. success request
    ```sh
    curl  'http://127.0.0.1:8080/order/9' -H "Content-Type: application/json"
    ```
    ```json
    {
        "id": 9
    }
    ```