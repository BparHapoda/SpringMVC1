package ru.boronin.springMVC.models;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @NotNull
    private int id;
    @NotNull(message = "Name can`t be empty")
    @Size(min=3,message = "Name must be longer")
    @Size(max = 30,message = "Name must be shorter")
    private String name;
    @NotNull(message = "Surname can`t be empty")
    @Size(min=3,message = "Name must be longer")
    @Size(max = 30,message = "Name must be shorter")
    private String surname;
    @NotNull(message = "Login can`t be empty")
    @Size(min=3,message = "Name must be longer")
    @Size(max = 30,message = "Name must be shorter")
    private String login;
    @NotNull(message = "Password can`t be empty")
    @Size(min=3,message = "Name must be longer")
    @Size(max = 30,message = "Name must be shorter")
    private String password;
    @NotNull(message = "Email can`t be empty")
    @Email(message = "Wrong format of email address")
    private String email;
}
