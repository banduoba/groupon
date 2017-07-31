package com.qianli.groupon.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author meng
 * @create 2017-07-30 23:48
 */

@Data
@Entity
public class ArticleDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String articleContent;
}
