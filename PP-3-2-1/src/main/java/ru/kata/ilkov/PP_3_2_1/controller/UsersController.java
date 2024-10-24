package ru.kata.ilkov.PP_3_2_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kata.ilkov.PP_3_2_1.model.User;
import ru.kata.ilkov.PP_3_2_1.service.UsersService;

@Controller
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping(value = "/users")
    public String printUsers(ModelMap model) {
        model.addAttribute("usersList", usersService.getAllUsers());
        return "users/index";
    }

    @GetMapping(value = "/userid")
    public String show(@RequestParam int id, ModelMap model) {
        //System.out.println("ID: " + id);
        model.addAttribute("user", usersService.readUser(id));
        return "users/show";
    }

    @GetMapping(value = "/new")
    public String newUser(@ModelAttribute("newUser") User user) {
        return "users/new";
    }

    @PostMapping(value = "/users")
    public String addUser(@ModelAttribute("newUser") User user) {
        usersService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/delete")
    public String deleteUser(@RequestParam int id) {
        usersService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping(value = "/update")
    public String viewUser(@RequestParam int id, ModelMap model) {
        model.addAttribute("user", usersService.readUser(id));
        return "users/update";
    }

    @PostMapping(value = "/update")
    public String updateUser(@ModelAttribute("user") User user) {
        usersService.updateUser(user.getId(), user.getName(), user.getSecondName(), user.getAge());
        return "redirect:/users";
    }
}
