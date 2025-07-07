package com.BE_13.DevTogether.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * DevTogether의 CORS 설정 클래스이다.
 *
 * @author chan
 */
// front - localhost:5173
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * SpringBoot API 요청을 허용한다.
     *
     * @param registry CORS 등록
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 애플리케이션의 모든 API 경로에 CORS 설정을 적용한다.
                .allowedOrigins("http://localhost:5173") // 프론트엔드 주소(localhost:5173)에서의 요청을 허용한다.
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS") // 허용할 HTTP 메서드를 명시한다.
                .allowedHeaders("*") // 모든 종류의 요청 헤더를 허용한다.
                .allowCredentials(true) // 자격(쿠키 등)을 포함한 요청을 허용한다.
                .maxAge(3600); // 브라우저가 CORS 사전 요청 결과를 캐시할 시간을 설정한다. (현재 3600초(1시간))
    }
}
