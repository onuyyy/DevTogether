package com.BE_13.DevTogether.entity.testDataInit;

import com.BE_13.DevTogether.entity.user.Role;
import com.BE_13.DevTogether.entity.user.User;
import com.BE_13.DevTogether.entity.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * 테스트 설정 파일(application-test.yml) 사용시 동작하는 테스트 유저(User) 생성 클래스이다.
 *
 * @author chan
 */
@Configuration
@RequiredArgsConstructor
public class TestDataInit {

    private final UserRepository userRepository;

    private final Logger log = LoggerFactory.getLogger(getClass()); // 로그


    @Bean
    @Profile("test")
    public CommandLineRunner initTestUserData() {

        return args -> {
            log.debug("테스트용 사용자 데이터베이스를 생성합니다.");

            if (userRepository.count() == 0) {
                log.debug("테스트 사용자를 생성합니다.");

                // 일반 테스트 유저 db 생성
                User testUser = User.builder().
                        username("테스트유저").
                        role(Role.User).
                        build();

                userRepository.save(testUser);

                // 관리자 테스트 유저 db 생성
                User testAdmin = User.builder().
                        username("테스트관리자").
                        role(Role.ADMIN).
                        build();

                userRepository.save(testAdmin);

                log.debug("사용자 데이터 생성 완료 : {}", userRepository.findAll().stream().map(User::getUsername).toList());
            } else {
                log.debug("이미 데이터이가 존재하여 데이트를 건너뜁니다.");
            }
        };
    }

}
