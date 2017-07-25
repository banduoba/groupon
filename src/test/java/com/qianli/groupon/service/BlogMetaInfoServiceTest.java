package com.qianli.groupon.service;

import com.qianli.groupon.model.BlogMetaInfo;
import com.qianli.groupon.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BlogMetaInfoServiceTest {

    @Autowired
    private BlogMetaInfoService blogMetaInfoService;

    @Test
    public void save() throws Exception {
        User user = new User();
        user.setName("blog");
        user.setAge(25);
        user.setCreate_time(new Date());
        user.setEmail("blog@126.com");

        BlogMetaInfo blogMetaInfo = new BlogMetaInfo();
        blogMetaInfo.setInro("inro");
        blogMetaInfo.setPicUrl("http://www.baidu.com");
        blogMetaInfo.setTitle("title");
        blogMetaInfo.setUser(user);

        blogMetaInfoService.save(blogMetaInfo);
    }

}