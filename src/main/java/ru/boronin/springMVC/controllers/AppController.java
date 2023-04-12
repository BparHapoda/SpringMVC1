package ru.boronin.springMVC.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.boronin.springMVC.Dao.UserDao;
import ru.boronin.springMVC.models.User;

import java.util.List;

@Controller
//@RequestMapping("/users")
public class AppController {
    private UserDao dao;
    @Autowired
    public AppController(UserDao dao){
        this.dao=dao;

    }
    @GetMapping("/")
    public String rootView (){
     return "users/index";
    }
    @PostMapping ("/login")
    public String login (@RequestParam("login") String login,@RequestParam("password") String password,Model model){
        User user=dao.getUserByLogin(login);
        model.addAttribute("user",user);
        if (user==null || !user.getPassword().equals(password)){
        return "redirect:/";}
        else return "users/login";
    }

    @GetMapping("/registration")
    public String registration (Model model){
        model.addAttribute("user",new User());
        return "users/registration";
    }
    @PostMapping("/newUser")
    public String create(Model model,@ModelAttribute("user")User user){
        dao.save(user);
        model.addAttribute("user",user);
        return "users/newUser";
    }

    @GetMapping("/admin")
    public String admin (){
        return "users/admin";
    }
    @GetMapping("/all")
    public String all (Model model){
        List<User> users=dao.getAllUsers();
        model.addAttribute("users",users);
        return "users/all";
    }
}
