package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showAllUsers (Model model) {
        model.addAttribute("Users",userService.getAllUsers());
        return "all-users";
    }

    @GetMapping("/addNewUser")
    public String addNewUser (@ModelAttribute("userInfo") User user) {
        return "user-info";
    }

    @PostMapping("/saveUser")
    public String saveUser (@ModelAttribute("userInfo") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updateUser (@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("userInfo",userService.showUser(id));
        return "update";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("userInfo") User user, @PathVariable(value = "id") Long id) {
        userService.update(id,user);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser (@PathVariable(value = "id") Long id) {
        userService.delete(id);
        return "redirect:/";
    }
}
