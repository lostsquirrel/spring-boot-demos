package demo.spring.rabbitmq;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class RabbitApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(RabbitApplication.class).run(args);
    }
}
