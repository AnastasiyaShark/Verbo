package com.shark.App.security;

import com.shark.App.exeption.ErrorUnauthorized;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
//JwtAuthEntryPoint используется для обработки исключения ошибки при наличии неавторизованных запросов.
public class AuthEntryPointJwt implements AuthenticationEntryPoint {
    private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);

    //Error 401
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException){
        logger.error("Unauthorized error: {}", authException.getMessage());
        throw new ErrorUnauthorized("Unauthorized error");
    }
}
