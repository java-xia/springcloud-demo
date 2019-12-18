package com.leyou.controller;

import com.leyou.pojo.User;
import com.leyou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consume")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public User queryUserById(@RequestParam("id") Long id){
        return userService.queryById(id);
    }
}
