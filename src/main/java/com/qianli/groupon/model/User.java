package com.qianli.groupon.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.FetchType.EAGER;

/**
 * @author meng
 * @create 2017-07-23 13:29
 */

@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Basic(optional = false,fetch = EAGER)
    private String name;
    private String email;
    private Integer age;
    @Temporal(TemporalType.TIMESTAMP)
    private Date create_time;

    public User() {
    }

    public User(String name, String email, Integer age, Date create_time) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%d, name='%s', email='%s']",
                id, name, email);
    }
}
