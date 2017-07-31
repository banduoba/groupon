package com.qianli.groupon.repository;

import com.qianli.groupon.model.Article;
import com.qianli.groupon.model.ArticleDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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

        // 根据关系维护方法不懂，保存顺序也不一样
        // 此示例维护端是ArticleDetail，所以先保存被维护端Article
        // 同时需要通过ArticleDetail类来设置关联关系
        // 保存的时候也要注意，先保存被维护端Article，然后保存维护端ArticleDetail

        // 设置关联关系
        articleDetail.setArticle(article);

//        article.setArticleDetail(articleDetail);

        articleRepository.save(article);
        articleDetailRepository.save(articleDetail);
    }

    // 测试获取关联对象属性
    // 有外键方，查看终端输出语句可以发现是2条sql查询语句
    @Test
    public void find() {
        Article article = articleRepository.findOne(1);
//        System.out.println(String.format("%s:%s",article.getTitle(),article.getArticleDetail().getArticleContent()));
        System.out.println(article.getArticleDetail().getArticleContent());
    }

    @Test
    public void findAllArticleOne() {
        List<Article> articles = articleRepository.findAll();
        for (Article article : articles) {
            System.out.println(article.getTitle());
        }
    }

    // 测试获取关联对象的属性值
    // 1条sql,无外键方
    @Test
    public void findArticleDetail() {
        ArticleDetail articleDetail = articleDetailRepository.findOne(1);
        System.out.println(articleDetail.getArticleContent());

    }

    @Test
    public void findAllArticleTwo() {
        List<ArticleDetail> articleDetails = articleDetailRepository.findAll();
        for (ArticleDetail articleDetail : articleDetails) {
            Article article = articleDetail.getArticle();
            System.out.println(article.getTitle());
        }
    }

    @Test
    public void delete() {
        articleRepository.delete(1);
    }
}