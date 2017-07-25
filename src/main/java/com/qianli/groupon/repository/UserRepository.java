package com.qianli.groupon.repository;

import com.qianli.groupon.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author meng
 * @create 2017-07-23 13:40
 */

//@RepositoryDefinition(domainClass = User.class,idClass = Long.class)
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByName(String name);

    List<User> findByNameStartingWithAndAgeLessThan(String name, Integer age);

    @Query("select u from User u where id = (select max(id) from User u1)")
    User findUserByMaxId();

    @Modifying
    @Query("update User o set o.name = :name where o.id = :id")
    void updateUserName(@Param("id") Long id, @Param("name") String name);
}
