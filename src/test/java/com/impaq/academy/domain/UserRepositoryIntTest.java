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
public class UserRepositoryIntTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void shouldFindUserByLogin() {
        //given
        String login = "jacek";

        //when
        User user = repository.findUserByLogin(login);

        //then
        assertThat(user).isNotNull();
        assertThat(user.getLogin()).isEqualTo(login);
    }

    @Test
    public void shouldFindUsersWithPostsAfter() {
        //given
        LocalDateTime date = LocalDateTime.of(2016, 4, 20, 14, 0);

        //when
        List<User> users = repository.findByPostsCreationDateAfter(date);

        //then
        assertThat(users).hasSize(1);
    }

    @Test
    public void shouldListInactiveUsers() {
        //when
        List<User> inactiveUsers = repository.findByActiveFalse();

        //then
        assertThat(inactiveUsers).hasSize(1);
        assertThat(inactiveUsers.get(0).getLogin()).isEqualTo("placek");
    }
}