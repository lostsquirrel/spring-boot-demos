package demo.spring.rabbitmq.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
public class MyProperties {
    @Value("${my.queue.name}")
    private String queueName;

    @Value("${my.exchange.name}")
    private String exchangeName;

    public String getQueueName() {
        return queueName;
    }

    public String getExchangeName() {
        return exchangeName;
    }
}
