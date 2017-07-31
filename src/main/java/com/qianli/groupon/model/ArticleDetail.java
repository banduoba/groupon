package com.qianli.groupon.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author meng
 * @create 2017-07-30 23:48
 */

// 维护端(无外键方)
@Data
@Entity
public class ArticleDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String articleContent;

    @OneToOne
    private Article article;
}
