package com.BE_13.DevTogether;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * 패스트 캠퍼스 백엔드 개발
 * 13기 조희찬(Tato126), 정욱(MiSa-JD), 김윤영(onuyyy) 가 만드는 코드 게시판이다.
 *
 * @author chan
 */
@SpringBootApplication
@EnableConfigurationProperties
public class DevTogetherApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevTogetherApplication.class, args);
    }

}
