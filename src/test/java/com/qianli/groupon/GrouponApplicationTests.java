package com.qianli.groupon;

import com.qianli.groupon.model.User;
import com.qianli.groupon.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GrouponApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
	public void contextLoads() {
        List<User> users = userRepository.findByName("Jack");
        for (User user : users) {
            System.out.println(user);
        }
    }

}
