package com.qianli.groupon.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author meng
 * @create 2017-07-25 09:48
 */

@Entity
@Getter
@Setter
public class BlogMetaInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;
    private String inro;
    private String picUrl;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",unique = true)
    private User user;
}
