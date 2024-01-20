package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    /**
     * Уведомление о создании нового пользователя
     * @param user
     */
    public void notifyUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
    }

    /**
     * Печать уведомления
     * @param s
     */
    public void sendNotification(String s) {
        System.out.println(s);
    }
}
