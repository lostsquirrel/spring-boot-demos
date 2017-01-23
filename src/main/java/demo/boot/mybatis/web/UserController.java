package demo.boot.mybatis.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.boot.dao.UserMapper;
import demo.boot.domain.User;


@Controller
@EnableAutoConfiguration
@MapperScan("demo.boot.dao")
public class UserController {

	@Autowired
	private UserMapper userMapper;
	
    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }
    
    @RequestMapping("/user/add")
    @ResponseBody
    String add(User user) {
    	userMapper.insertUser(user);
    	return "OK";
    }
    
    @RequestMapping("/user/{uid}")
    @ResponseBody
    String user(@PathVariable("uid") Integer userId) {
    	return userMapper.findUserById(userId).toString();
    }
    
    @RequestMapping("/user/list")
    @ResponseBody
    String list() {
    	return userMapper.findAllUsers().toString();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(UserController.class, args);
    }
}