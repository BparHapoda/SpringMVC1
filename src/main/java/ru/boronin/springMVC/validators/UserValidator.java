package ru.boronin.springMVC.validators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.boronin.springMVC.Dao.UserDao;
import ru.boronin.springMVC.models.User;
@Component
@Data
public class UserValidator implements Validator {
    private UserDao dao;
    @Autowired
   public UserValidator (UserDao dao){
       this.dao=dao;
   }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
User user=(User) target;
if(dao.getUserByLogin(user.getLogin())!=null){errors.rejectValue("name","","" +
        "This login is used");}
    }
}
