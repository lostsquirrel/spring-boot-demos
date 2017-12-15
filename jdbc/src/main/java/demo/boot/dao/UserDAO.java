package demo.boot.dao;

import java.util.List;

import demo.boot.domain.User;

public interface UserDAO {

	long insertUser(User user);

	User findUserById(long id);

	List<User> findAllUsers();
}
