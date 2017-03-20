package demo.boot.jdbc.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"demo.boot.dao", "demo.boot.jdbc.web"}) 
public class Application {
	public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }
}
