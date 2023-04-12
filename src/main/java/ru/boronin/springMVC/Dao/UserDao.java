package ru.boronin.springMVC.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.boronin.springMVC.models.User;

import java.util.List;

@Component
public class UserDao {
    private final JdbcTemplate jdbcTemplate;
@Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<User> getAllUsers(){
    return jdbcTemplate.query("SELECT * FROM users",new BeanPropertyRowMapper<>(User.class));
    }
    public  User getUserById (int id){
    return jdbcTemplate.query("SELECT * FROM users WHERE id=?",new Object[]{id},new BeanPropertyRowMapper<>(User.class)).stream().findAny().orElse(null);
    }
    public  User getUserByLogin (String login){
        return jdbcTemplate.query("SELECT * FROM users WHERE login=?",new Object[]{login},
                new BeanPropertyRowMapper<>(User.class)).stream().findAny().orElse(null);
    }
    public void save (User user){
    jdbcTemplate.update("INSERT INTO users (email,login,name,password,surname)" +
                    "VALUES (?,?,?,?,?)",user.getEmail(),user.getLogin(),user.getName(),
            user.getPassword(),user.getSurname());
    }
    public void update (int id,User updatedUser){
    jdbcTemplate.update("UPDATE users SET name=?,surname=?,email=?,password=?,login=? WHERE id=?",
            updatedUser.getName(),updatedUser.getSurname(),updatedUser.getEmail(),updatedUser.getPassword(),
            updatedUser.getLogin(),updatedUser.getId());
    }
public void delete (int id){
    jdbcTemplate.update("DELETE FROM users WHERE id=?",id);
}
}
