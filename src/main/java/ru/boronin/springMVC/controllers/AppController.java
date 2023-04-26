package ru.boronin.springMVC.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.boronin.springMVC.Dao.UserDao;
import ru.boronin.springMVC.models.User;
import ru.boronin.springMVC.validators.UserValidator;

import java.util.List;

@Controller
//@RequestMapping("/users")
public class AppController {
    private UserDao dao;
    private UserValidator validator;
    @Autowired
    public AppController(UserDao dao,UserValidator validator){
        this.validator=validator;
        this.dao=dao;

    }
    @GetMapping("/")
    public String rootView (){
     return "index";
    }
    @PostMapping ("/login")
    public String login (@RequestParam("login") String login,
                         @RequestParam("password") String password,Model model){
        User user=dao.getUserByLogin(login);
        model.addAttribute("loginUser",user);
        if (user==null || !user.getPassword().equals(password)){
        return "redirect:/";}
        else return "login";
    }

    @GetMapping("/registration")
    public String registration (Model model){
        model.addAttribute("user",new User());
        return "registration";
    }
    @PostMapping("/newUser")
    public String create(Model model, @ModelAttribute("user") @Valid User user, BindingResult bindingResult){
        validator.validate(user,bindingResult);
        if (bindingResult.hasErrors()){return "registration";}
        dao.save(user);
        model.addAttribute("user",user);
        return "newUser";
    }

    @GetMapping("/admin")
    public String admin (){
        return "admin";
    }
    @GetMapping("/all")
    public String all (Model model){
        List<User> users=dao.getAllUsers();
        model.addAttribute("users",users);
        return "all";
    }
}
