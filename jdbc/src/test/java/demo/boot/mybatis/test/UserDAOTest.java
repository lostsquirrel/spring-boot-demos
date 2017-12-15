package demo.boot.mybatis.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import demo.boot.dao.UserDAO;
import demo.boot.domain.User;
import demo.boot.jdbc.app.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)	
public class UserDAOTest {

	@Autowired
	private UserDAO userDAO;

	@Test
	public void findAllUsers() {
		List<User> users = userDAO.findAllUsers();
		assertNotNull(users);
		assertTrue(!users.isEmpty());
	}

	@Test
	public void findUserById() {
		User user = userDAO.findUserById(1);
		assertNotNull(user);
	}

	@Test
	public void createUser() {
		User user = new User(null, "Bob", "bob@gmail.com");
		long id = userDAO.insertUser(user);
		User newUser = userDAO.findUserById(id);
		assertEquals("Bob", newUser.getName());
		assertEquals("bob@gmail.com", newUser.getEmail());
	}
}
