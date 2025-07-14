package com.BE_13.DevTogether.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import java.io.IOException;
import java.net.URLEncoder;

@Slf4j
public class UserAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        if (exception != null) {
            logger.warn(exception.getMessage());
        }
        // 로그 찍고 바로 실패 URL로 리다이렉트

        super.setDefaultFailureUrl("/loginFail?error=true");
        super.onAuthenticationFailure(request, response, exception);
    }

}
