package demo.spring.boot.prometheus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpServletRequest;

@RestController
@EnableAutoConfiguration
public class Application {
    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/session")
    String session(HttpServletRequest req) {
        return req.getSession().getId();
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
