package com.qianli.groupon.service;

import com.qianli.groupon.modle.User;
import com.qianli.groupon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author meng
 * @create 2017-07-23 13:47
 */

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findUserByName(String name) {
        return userRepository.findByName(name);
    }

    public List<User> getUserName(String name,Integer age) {
        return userRepository.findByNameStartingWithAndAgeLessThan(name, age);
    }

    @Transactional
    public void updateUserName(Long id,String name) {
        userRepository.updateUserName(id, name);
    }

    public List<User> findAllUser() {
        Iterable<User> users = userRepository.findAll();
        return (List<User>) users;
    }
}
