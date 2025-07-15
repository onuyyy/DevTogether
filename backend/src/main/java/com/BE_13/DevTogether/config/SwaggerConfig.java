package com.BE_13.DevTogether.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        Info info = new Info()
                .title("DevTogether")
                .description("코드 리뷰 플랫폼 API 입니다.");

        return new OpenAPI();
    }
}
