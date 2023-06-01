package com.logic.nemonemo.service;

import com.logic.nemonemo.dto.response.UserResponse;
import com.logic.nemonemo.entity.User;
import com.logic.nemonemo.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Test
    public void shouldFindUserById() throws Exception {
        //given
        Long id = 1L;
        User user = userRepository.save(User.builder()
                        .id(id)
                        .nickname("choi")
                        .password("1234")
                        .build());
        //when
        UserResponse userResponse = userService.getUserById(id);
        //then
        assertThat(userResponse.getId()).isEqualTo(1L);
        assertThat(userResponse.getNickname()).isEqualTo("choi");
        assertThat(userResponse.getPassword()).isEqualTo("1234");
    }
}