package com.impaq.academy.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDateTime;
import java.util.List;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long> {

    User findUserByLogin(@Param("login") String login);

    @Query("select u from User u left outer join u.posts p where p.creationDate > :date")
    List<User> findByPostsCreationDateAfter(@Param("date") LocalDateTime date);

    List<User> findByActiveFalse();

}