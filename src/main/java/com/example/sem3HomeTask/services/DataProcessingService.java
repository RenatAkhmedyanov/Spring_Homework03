package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {

    /**
     * Репозиторий пользователей
     * @return
     */
    @Autowired
    private UserRepository repository;

    /**
     * Получить репозиторий пользователей
     * @return
     */
    public UserRepository getRepository() {
        return repository;
    }


    /**
     * Соритровака пользователей по возрасту
     * @param users
     * @return
     */
    public List<User> sortUsersByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    /**
     * Фильтрация пользователей по возрасту
     * @param users
     * @param age
     * @return
     */
    public List<User> filterUsersByAge(List<User> users, int age) {
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    /**
     * Вычисление среднего возраста пользователей
     * @param users
     * @return
     */
    public double calculateAverageAge(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

    /**
     * Добавление пользователя
     * @param user
     */
    public void  addUserToList(User user)
    {
        repository.getUsers().add(user);
    }
}
