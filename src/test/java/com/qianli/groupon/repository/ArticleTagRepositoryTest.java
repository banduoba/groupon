package com.qianli.groupon.repository;

import com.qianli.groupon.model.Article;
import com.qianli.groupon.model.ArticleDetail;
import com.qianli.groupon.model.ArticleTag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ArticleTagRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleTagRepository articleTagRepository;

    @Autowired
    private ArticleDetailRepository articleDetailRepository;

    @Test
    public void save() {
        Article article = new Article();
        article.setTitle("spring boot 实战系列");

        ArticleDetail articleDetail = new ArticleDetail();
        articleDetail.setArticleContent("spring boot实战是一本不错的入门教程");

        article.setArticleDetail(articleDetail);

        ArticleTag articleTag = new ArticleTag();
        articleTag.setTagName("spring boot");
        articleTag.setArticle(article);

        ArticleTag articleTag1 = new ArticleTag();
        articleTag1.setTagName("spring");
        articleTag1.setArticle(article);

        List<ArticleTag> articleTags = new ArrayList<>();
        articleTags.add(articleTag);
        articleTags.add(articleTag1);


        article.setArticleTags(articleTags);

        articleDetailRepository.save(articleDetail);
        // 第二个保存，否则报错
        articleRepository.save(article);
        articleTagRepository.save(articleTags);
    }

    @Test
    @Transactional
    public void find() {
        Article article = articleRepository.findOne(1);
        List<ArticleTag> articleTags = article.getArticleTags();
        for (ArticleTag articleTag : articleTags) {
            System.out.println(articleTag);
        }
    }

}