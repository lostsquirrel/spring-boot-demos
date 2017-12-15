package demo.boot.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.jdbc.Statement;

import demo.boot.dao.UserDAO;
import demo.boot.domain.User;

@Component("userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
    JdbcTemplate jdbcTemplate;
	
	private RowMapper<User> rowMapper;
	
	public UserDAOImpl() {
		rowMapper = new BeanPropertyRowMapper<User>(User.class);
	}
	
	@Override
	@Transactional
	public long insertUser(final User user) {
		final String sql = "INSERT INTO users(name, email) VALUES (?, ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		PreparedStatementCreator action = new PreparedStatementCreator(){
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setObject(1, user.getName());
				ps.setObject(2, user.getEmail());
				return ps;
			}
			
		};
		jdbcTemplate.update(action, keyHolder);
		
		return keyHolder.getKey().longValue();
	}

	@Override
	public User findUserById(long id) {
		String sql = "SELECT id, name, email FROM users WHERE id=?";
		return jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
	}

	@Override
	public List<User> findAllUsers() {
		String sql = "SELECT id, name, email FROM users LIMIT 10";
		return jdbcTemplate.query(sql, rowMapper);
	}

}
