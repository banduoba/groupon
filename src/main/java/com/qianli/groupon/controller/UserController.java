package com.qianli.groupon.controller;

import com.qianli.groupon.modle.User;
import com.qianli.groupon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author meng
 * @create 2017-07-23 15:11
 */

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @RequestMapping(value = "/user")
    public String getUser() {
        Iterable<User> users = repository.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        return "获取用户成功";
    }
}
