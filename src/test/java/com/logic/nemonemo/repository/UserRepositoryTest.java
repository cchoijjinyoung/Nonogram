package com.logic.nemonemo.repository;

import com.logic.nemonemo.entity.User;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Autowired UserRepository userRepository;

    @DisplayName("테스트를 위한 기본회원 저장")
    private void saveBasicUser() {
        userRepository.save(User.builder()
                .username("foo")
                .nickname("bar")
                .password("1234")
                .build());
    }
    @BeforeEach
    void cleanUp() {
        userRepository.deleteAll();
    }
    @AfterEach
    void clean() {
        userRepository.deleteAll();
    }
    @Test
    @DisplayName("유저 저장 테스트")
    @Transactional // Jpa는  트랜젝션안에서 엔티티의 동일성을 보장한다.
    public void shouldSaveUser() {
        // given
        User insertUser = userRepository.save(User.builder()
                .username("New-nickname")
                .nickname("New-username")
                .password("New-password")
                .build());
        // when
        User findUser = userRepository.findById(insertUser.getId()).get();

        // then
        assertThat(insertUser).isEqualTo(findUser);
    }
    @Test
    @DisplayName("유저네임으로 회원 조회")
    public void shouldFindUserByUsername() throws Exception {
        saveBasicUser();
        //when
        User findUser = userRepository.findByUsername("foo").get();
        //then
        assertThat(findUser.getUsername()).isEqualTo("foo");
        assertThat(findUser.getPassword()).isEqualTo("1234");
        assertThat(findUser.getNickname()).isEqualTo("bar");
    }
}