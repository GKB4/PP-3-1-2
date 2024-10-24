package ru.kata.ilkov.PP_3_2_1.service;

import ru.kata.ilkov.PP_3_2_1.model.User;

import java.util.List;

public interface UsersService {
    void createUser(String name, String secondName, int age);

    void updateUser(int id, String name, String secondName, int age);

    void deleteUser(int id);

    User readUser(int id);

    List<User> getAllUsers();

    void createUser(User user);
}
