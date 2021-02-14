package com.supportportal.api.v1.controller;

import com.supportportal.api.v1.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {  "/api/vi/user"})
@AllArgsConstructor
public class UserController {

    private final UserService userService;

}
