package com.qianli.groupon.service;

import com.qianli.groupon.model.BlogMetaInfo;
import com.qianli.groupon.repository.BlogMetaInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author meng
 * @create 2017-07-25 10:01
 */

@Service
public class BlogMetaInfoService {

    @Autowired
    private BlogMetaInfoRepository blogMetaInfoRepository;

    public void save(BlogMetaInfo blogMetaInfo) {
        blogMetaInfoRepository.save(blogMetaInfo);
    }
}
