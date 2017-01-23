package demo.boot.mybatis.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("demo.boot.dao")
public class SpringbootMyBatisDemoApplication {
	public static void main(String[] args)
    {
        SpringApplication.run(SpringbootMyBatisDemoApplication.class, args);
    }
}
