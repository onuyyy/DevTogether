package com.BE_13.DevTogether.config.cors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * CORS 설정 테스트 클래스
 * 실제 브라우저의 CORS 동작은 완전히 테스트할 수 없지만,
 * 서버의 CORS 헤더 응답은 검증할 수 있다.
 *
 * @author gimtaehui
 */
@SpringBootTest
@AutoConfigureMockMvc
class CorsConfigTest {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("허용된 Origin에서 요청 시 CORS 헤더가 올바르게 설정된다 - devtogether.pages.dev")
    @Test
    void corsHeadersSetCorrectlyForAllowedOrigin_DevTogetherSite() throws Exception {
        mockMvc.perform(options("/api/posts")
                        .header(HttpHeaders.ORIGIN, "https://devtogether.pages.dev")
                        .header(HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD, "GET")
                        .header(HttpHeaders.ACCESS_CONTROL_REQUEST_HEADERS, "content-type"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "https://devtogether.pages.dev"))
                .andExpect(header().string(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "GET,HEAD,POST,PUT,DELETE,PATCH,OPTIONS"))
                .andExpect(header().string(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "content-type"))
                .andExpect(header().string(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true"))
                .andExpect(header().string(HttpHeaders.ACCESS_CONTROL_MAX_AGE, "3600"));
    }


    @DisplayName("허용된 Origin에서 요청 시 CORS 헤더가 올바르게 설정된다 - localhost:5173")
    @Test
    void corsHeadersSetCorrectlyForAllowedOrigin_Localhost() throws Exception {
        mockMvc.perform(options("/api/posts")
                        .header(HttpHeaders.ORIGIN, "http://localhost:5173")
                        .header(HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD, "POST")
                        .header(HttpHeaders.ACCESS_CONTROL_REQUEST_HEADERS, "content-type,authorization"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "http://localhost:5173"))
                .andExpect(header().string(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true"));
    }

    @DisplayName("허용되지 않은 Origin에서 요청 시 CORS 헤더가 설정되지 않는다")
    @Test
    void corsHeadersNotSetForUnallowedOrigin() throws Exception {
        mockMvc.perform(options("/api/posts")
                        .header(HttpHeaders.ORIGIN, "https://malicious-site.com")
                        .header(HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD, "GET"))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @DisplayName("실제 GET 요청에서 CORS 헤더가 포함된다")
    @Test
    void actualGetRequestIncludesCorsHeaders() throws Exception {
        mockMvc.perform(get("/api/posts")
                        .header(HttpHeaders.ORIGIN, "https://devtogether.pages.dev"))
                .andDo(print())
                .andExpect(header().string(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "https://devtogether.pages.dev"))
                .andExpect(header().string(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true"));
    }

    @DisplayName("HEAD 메서드가 CORS에서 지원된다")
    @Test
    void headMethodIsSupportedInCors() throws Exception {
        mockMvc.perform(options("/api/posts")
                        .header(HttpHeaders.ORIGIN, "https://devtogether.pages.dev")
                        .header(HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD, "HEAD"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "https://devtogether.pages.dev"))
                .andExpect(header().string(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "GET,HEAD,POST,PUT,DELETE,PATCH,OPTIONS"))
                .andExpect(header().string(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true"));
    }

    @DisplayName("허용된 모든 HTTP 메서드가 CORS에서 지원된다")
    @Test
    void allAllowedMethodsAreSupportedInCors() throws Exception {
        String[] methods = {"GET", "HEAD", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"};
        
        for (String method : methods) {
            mockMvc.perform(options("/api/posts")
                            .header(HttpHeaders.ORIGIN, "https://devtogether.pages.dev")
                            .header(HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD, method))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(header().exists(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN));
        }
    }

    @DisplayName("허용되지 않은 HTTP 메서드는 CORS에서 거부된다")
    @Test
    void unauthorizedMethodIsRejectedInCors() throws Exception {
        mockMvc.perform(options("/api/posts")
                        .header(HttpHeaders.ORIGIN, "https://devtogether.pages.dev")
                        .header(HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD, "TRACE"))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @DisplayName("복잡한 요청의 preflight 검증")
    @Test
    void complexRequestPreflightValidation() throws Exception {
        mockMvc.perform(options("/api/posts")
                        .header(HttpHeaders.ORIGIN, "https://devtogether.pages.dev")
                        .header(HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD, "POST")
                        .header(HttpHeaders.ACCESS_CONTROL_REQUEST_HEADERS, 
                                "Content-Type,Authorization,X-Requested-With"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "https://devtogether.pages.dev"))
                .andExpect(header().string(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "Content-Type, Authorization, X-Requested-With"));
    }
}