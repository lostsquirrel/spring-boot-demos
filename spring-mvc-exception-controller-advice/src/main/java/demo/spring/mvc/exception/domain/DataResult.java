package demo.spring.mvc.exception.domain;

public class DataResult {

    public static final int STATUS_SUCCESS = 1;

    public static final int STATUS_FAIL = 0;

    private int status;

    private String message;

    private Object data;

    public DataResult(String message) {
        this.status = STATUS_SUCCESS;
        this.message = message;
    }

    public DataResult(Object data) {
        this.status = STATUS_FAIL;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
