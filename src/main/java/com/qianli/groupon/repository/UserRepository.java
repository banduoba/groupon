package com.qianli.groupon.repository;

import com.qianli.groupon.modle.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author meng
 * @create 2017-07-23 13:40
 */

public interface UserRepository extends CrudRepository<User, Long> {
    User findByName(String name);
}
