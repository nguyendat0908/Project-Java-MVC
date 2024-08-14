package vn.hoidanit.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import vn.hoidanit.laptopshop.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    private UserService userService;

    // Dependency Injection - DI
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        String test = this.userService.handleHello();
        model.addAttribute("dat", test);
        model.addAttribute("datdeptrai", "Dat dep trai nhat trai dat!");
        return "hello";
    }

}

