package com.BE_13.DevTogether.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@Configuration
public class JpaConfig {
    // todo : 현재 로그인 로직 통해서 사용자 정보를 저장하는 부분은 구현되어 있지 않음
    //         생성자, 수정자 등도 Auditing 기능 쓰려면 수정해야 함
}
