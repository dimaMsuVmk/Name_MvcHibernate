package web.controller;

import hiber.model.User;
import hiber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    private final UserService userService;

    @Autowired
    public HelloController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }
    @GetMapping("/users/{id}")
    public String getById(@PathVariable("id") long id, Model model) {
        model.addAttribute("id",id);
        model.addAttribute("user", userService.getUserById(id));
        return  "userById";
    }
    @GetMapping("/users/{id}/edit")
    public String edit (@PathVariable("id") long id,Model model){
        model.addAttribute("user",userService.getUserById(id));
        return "edit";
    }
    @PatchMapping("/users/{id}")
    public String updatePerson(@ModelAttribute("user") User updateuser){
        userService.updateUser(updateuser);
        return "redirect:/users";
    }
    @DeleteMapping("/users/{id}")
    public String deletePerson(@PathVariable("id") long id){
        userService.removeUserById(id);
        return "redirect:/users";
    }

    @PostMapping("/users")
    public String create(@ModelAttribute User user) {
        userService.save(user);
        return "users";
    }
}
