package com.qianli.groupon.model;

import com.qianli.groupon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.Date;

/**
 * 数据库初始化
 *
 * @author meng
 * @create 2017-07-23 21:12
 */

public class InitializedDatabase implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {

        repository.save(new User("Jack", "Bauer@gmail.com", 12, new Date()));
        repository.save(new User("Chloe", "OBrian@gmail.com", 14, new Date()));
        repository.save(new User("Kim", "BauerKin@gmail.com", 20, new Date()));
        repository.save(new User("David", "Palmer@gmail.com", 25, new Date()));
        repository.save(new User("Michelle", "Dessler@gmail.com", 18, new Date()));
    }
}
