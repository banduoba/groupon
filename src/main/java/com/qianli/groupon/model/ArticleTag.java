package com.qianli.groupon.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author meng
 * @create 2017-07-31 00:48
 */

@Entity
@Data
@ToString(exclude = "article")
public class ArticleTag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String tagName;

    @ManyToOne
    private Article article;
}
