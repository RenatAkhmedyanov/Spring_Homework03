package com.example.sem3HomeTask.controllers;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.services.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/tasks")
public class TaskController {

    /**
     * Сервис обработки данных
     */
    @Autowired
    private DataProcessingService service;

    /**
     * Получить список всех задач
     * @return
     */
    @GetMapping
    public List<String> getAllTasks()
    {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    /**
     * Получить список пользователей, отсортированных по возрасту
     * @return
     */
    @GetMapping("/sort")//localhost:8080/tasks/sort
    public List<User> sortUsersByAge()
    {
        return service.sortUsersByAge(service.getRepository().getUsers());
    }

    /**
     * Получить список пользователей старше указанного возраста
     * @param age
     * @return
     */
    @GetMapping("/filter/{age}")
    public List<User> filterUserByAge(@PathVariable("age") int age) {
        List<User> users = service.getRepository().getUsers();
        return service.filterUsersByAge(users, age);
    }

    /**
     * Рассчитать средний возраст пользователей
     * @return
     */
    @GetMapping("/calc")
    public double calculateAverageAge() {
        List<User> users = service.getRepository().getUsers();
        return service.calculateAverageAge(users);
    }

}
