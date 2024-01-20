package com.example.sem3HomeTask.domain;

public class User {

    /**
     * Имя пользователя
     */
    private String name;
    /**
     * Возраст пользователя
     */
    private int age;

    /**
     * Электронный адрес пользователя
     */
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
