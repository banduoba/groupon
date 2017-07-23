package com.qianli.groupon.service;

import com.qianli.groupon.modle.User;
import com.qianli.groupon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author meng
 * @create 2017-07-23 13:47
 */

@Component
public class UserService implements CommandLineRunner {
    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... Strings) throws Exception {
        /**
         * do not modify the method
         */
        // save a couple of users
        repository.save(new User("Jack", "Bauer@gmail.com",new Date()));
        repository.save(new User("Chloe", "OBrian@gmail.com"));
        repository.save(new User("Kim", "BauerKin@gmail.com"));
        repository.save(new User("David", "Palmer@gmail.com"));
        repository.save(new User("Michelle", "Dessler@gmail.com"));

        // fetch all users
//        System.out.println("User found with findAll():");
//        System.out.println("-------------------------------");
//        for (User user : repository.findAll()) {
//            System.out.println(user);
//        }

    }
}
