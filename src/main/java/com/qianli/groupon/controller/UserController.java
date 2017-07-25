package com.qianli.groupon.controller;

import com.qianli.groupon.model.User;
import com.qianli.groupon.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author meng
 * @create 2017-07-23 15:11
 */

@Controller
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/{name}")
    @ResponseBody
    public String getUserByName(@PathVariable String name) {
        List<User> users = userService.findUserByName(name);
        for (User user : users) {
            logger.info(String.format("User[name='%s',email='%s']", user.getName(), user.getEmail()));
        }
        return "success";
    }

    @RequestMapping(value = "/userAge")
    public String getUserAndAge() {
        List<User> users = userService.getUserName("Jack", 21);

        for (User user : users) {
            System.out.println(user.getEmail());
        }

        return "success";
    }

    @RequestMapping(value = "/user")
    public ModelAndView getAllUsers() {
        List<User> allUser = userService.findAllUser();
        ModelAndView modelAndView = new ModelAndView("/user");
        modelAndView.addObject("allUser", allUser);
        return modelAndView;
    }
}
