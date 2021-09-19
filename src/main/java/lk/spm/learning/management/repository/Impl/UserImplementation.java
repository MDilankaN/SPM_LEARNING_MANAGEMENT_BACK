package lk.spm.learning.management.repository.Impl;

import lk.spm.learning.management.mappers.PersonMapper;
import lk.spm.learning.management.model.User;
import lk.spm.learning.management.repository.loginUserRepository;
import lk.spm.learning.management.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static lk.spm.learning.management.repository.Impl.Query.USERS;

@Repository
public class UserImplementation implements loginUserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public String validateUser(User user) {
        String sql = "SELECT type FROM users WHERE username=? AND password=?";
        try {
            String type = jdbcTemplate.queryForObject(sql, new Object[] {
                    user.getUsername(), user.getPassword() }, String.class);
            return type;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<User> getStudentList() {
        String sql = "SELECT * FROM users WHERE type = 'student' order by id";
        List<User> users = jdbcTemplate.query(sql, new PersonMapper());
        System.out.println(users);
        return users;
    }

    @Override
    public List<User> getTeacherList() {
        String sql = "SELECT * FROM users WHERE type = 'teacher' order by id";
        List<User> users = jdbcTemplate.query(sql, new PersonMapper());
        System.out.println(users);
        return users;
    }

    @Override
    public List<User> getUserList() {
        String sql = "SELECT * FROM users order by id";
        List<User> users = jdbcTemplate.query(sql, new PersonMapper());
        System.out.println(users);
        return users;
    }

    @Override
    public String getTeacherStatus(User user) {
        String sql = "SELECT status FROM users WHERE username=? AND password=?";
        try {
            String status = jdbcTemplate.queryForObject(sql, new Object[] {
                    user.getUsername(), user.getPassword() }, String.class);
            return status;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getUserID(User user) {
        String sql = "SELECT id FROM users WHERE username=? AND password=?";
        try {
            String id = jdbcTemplate.queryForObject(sql, new Object[] {
                    user.getUsername(), user.getPassword() }, String.class);
            return id;
        } catch (Exception e) {
            return null;
        }
    }
}
