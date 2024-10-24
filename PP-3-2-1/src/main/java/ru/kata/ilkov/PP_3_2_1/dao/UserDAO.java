package ru.kata.ilkov.PP_3_2_1.dao;

import ru.kata.ilkov.PP_3_2_1.model.User;

import java.util.List;

public interface UserDAO {
    void create(User user);

    void create(String name, String secondName, int age);

    User read(int id);

    void update(int id, String name, String secondName, int age);

    void delete(int id);

    List<User> readUsers();
}
