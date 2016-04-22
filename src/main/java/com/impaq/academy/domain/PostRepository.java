package com.impaq.academy.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDateTime;
import java.util.List;

@RepositoryRestResource
public interface PostRepository extends CrudRepository<Post, Long> {

    List<Post> findByTitleOrContentLikeAllIgnoreCase(@Param("title") String title, @Param("content") String content);

    @Query("select p from Post p where Upper(p.title) like Upper(:text) or Upper(p.content) like Upper(:text) ")
    List<Post> findPostsWithText(@Param("text") String text);

    List<Post> findPostsByCreationDateBetween(@Param("from") LocalDateTime from, @Param("to") LocalDateTime to);

    Long countUserPostsByUserLogin(@Param("login") String login);

}