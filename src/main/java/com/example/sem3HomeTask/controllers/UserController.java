package com.example.sem3HomeTask.controllers;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")//localhost:8080/user
public class UserController {


    /**
     * Сервис регистрации пользователей
     */
    @Autowired
    private RegistrationService service;

    /**
     * Получить список пользователей
     * @return
     */
    @GetMapping
    public List<User> userList() { return service.getDataProcessingService().getRepository().getUsers(); }

    /**
     * Добавление нового пользователя
     * @param user
     * @return
     */
    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user)
    {
        service.getDataProcessingService().getRepository().getUsers().add(user);
        return "User added from body!";
    }
}
