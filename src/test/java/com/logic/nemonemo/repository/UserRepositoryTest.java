package com.logic.nemonemo.repository;

import com.logic.nemonemo.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Autowired UserRepository userRepository;

    @Test
    @DisplayName("회원 가입 테스트")
    @Transactional // Jpa는  트랜젝션안에서 엔티티의 동일성을 보장한다.
    public void shouldSaveUser() {
        // given
        User insertUser = userRepository.save(User.builder()
                        .id(1L)
                        .nickname("choi")
                        .username("jin")
                        .password("1234")
                        .build());
        // when
        User saveUser = userRepository.findById(insertUser.getId()).get();

        // then
        Assertions.assertThat(insertUser).isEqualTo(saveUser);
    }

}