package ru.kata.ilkov.PP_3_2_1.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.ilkov.PP_3_2_1.dao.UserDAO;
import ru.kata.ilkov.PP_3_2_1.model.User;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    private final UserDAO userDAO;

    public UsersServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    @Override
    public void createUser(String name, String secondName, int age) {
        userDAO.create(name, secondName, age);
    }

    @Transactional
    @Override
    public void updateUser(int id, String name, String secondName, int age) {
        userDAO.update(id, name, secondName, age);
    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        userDAO.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public User readUser(int id) {
        return userDAO.read(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userDAO.readUsers();
    }

    @Transactional
    @Override
    public void createUser(User user) {
        userDAO.create(user);
    }
}
