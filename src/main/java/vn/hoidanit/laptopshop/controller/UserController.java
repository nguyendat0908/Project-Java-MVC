package vn.hoidanit.laptopshop.controller;

import org.springframework.stereotype.Controller;

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
    public String getHomePage() {
        return "dat.html";
    }

}

// @RestController
// public class UserController {

// private UserService userService;

// // Dependency Injection - DI
// public UserController(UserService userService) {
// this.userService = userService;
// }

// @GetMapping("/")
// public String getHomePage() {
// return this.userService.handleHello();
// }
// }
