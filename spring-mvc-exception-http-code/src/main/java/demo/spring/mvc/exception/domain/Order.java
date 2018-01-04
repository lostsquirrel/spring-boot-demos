package demo.spring.mvc.exception.domain;

import java.io.Serializable;

public class Order implements Serializable {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long id;

}
