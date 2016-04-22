package com.impaq.academy.domain;

import com.impaq.academy.MainApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MainApp.class)
@WebIntegrationTest(randomPort = true)
@Transactional
public class PostRepositoryIntTest {

    @Autowired
    private PostRepository repository;

    @Test
    public void shouldCountUserPosts() {
        //given
        String login = "wacek";

        //when
        final Long postsNumber = repository.countUserPostsByUserLogin(login);

        //then
        assertThat(postsNumber).isEqualTo(2L);
    }

    @Test
    public void shouldFindPostsWithGivenText() {
        //given
        String searchWord = "%T%";

        //when
        final List<Post> posts = repository.findByTitleOrContentLikeAllIgnoreCase(searchWord, searchWord);

        //then
        assertThat(posts).hasSize(2);
    }

    @Test
    public void shouldFindPostsWithGivenTextWithOneParameter() {
        //given
        String searchWord = "%T%";

        //when
        final List<Post> posts = repository.findPostsWithText(searchWord);

        //then
        assertThat(posts).hasSize(2);
    }

    @Test
    public void shouldFindPostsForDateRange() {
        //given
        LocalDateTime from = LocalDateTime.of(2016, 4, 20, 10, 0);
        LocalDateTime to = LocalDateTime.of(2016, 4, 20, 16, 0);

        //when
        final List<Post> posts = repository.findPostsByCreationDateBetween(from, to);

        //then
        assertThat(posts).hasSize(1);
    }

}