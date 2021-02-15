package com.supportportal.api.v1.controller;

import com.supportportal.api.v1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = {  "/api/v1/user"})
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register() {
        return userService.register();
    }

    @PostMapping("/login")
    public String login() {
        return "success";
    }

}
