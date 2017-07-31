package com.qianli.groupon.repository;

import com.qianli.groupon.model.Article;
import com.qianli.groupon.model.ArticleDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ArticleRepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleDetailRepository articleDetailRepository;

    @Test
    public void save() {
        Article article = new Article();
        article.setTitle("spring data jpa系列教程");

        ArticleDetail articleDetail = new ArticleDetail();
        articleDetail.setArticleContent("对于如何学习spring data jpa，是本文介绍的重点！");

        article.setArticleDetail(articleDetail);

        articleDetailRepository.save(articleDetail);
        articleRepository.save(article);
    }

    @Test
    public void find() {
        Article article = articleRepository.findOne(1);
//        System.out.println(String.format("%s:%s",article.getTitle(),article.getArticleDetail().getArticleContent()));
        System.out.println(article);
    }


    @Test
    public void delete() {
        articleRepository.delete(2);
    }
}