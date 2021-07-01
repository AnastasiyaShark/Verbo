package com.shark.App.service;

import com.shark.App.model.auth.JwtResponse;
import com.shark.App.model.auth.LoginForm;
import com.shark.App.repository.UserRepository;
import com.shark.App.security.JwtAuthTokenFilter;
import com.shark.App.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Component
@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final JwtProvider jwtProvider;
    private final JwtAuthTokenFilter jwtAuthTokenFilter;

    public JwtResponse authenticateUser(LoginForm loginRequest) {
        //конвертирует user'a
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getLogin(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //получаем токен
        String jwt = jwtProvider.generateJwtToken(authentication);

        Session newSession = new Session(loginRequest.getLogin(), jwt);

        //проверяем,есть ли уже такая сессия (login and token)
        if (!sessionService.checkSessionRepository(newSession)) {
            throw new ErrorInputData(String.format(
                    "Невозможно войти! Сессия для пользователя с login = %s уже существует", loginRequest.getLogin()));
        }
        //сохраняем сессию
        sessionService.saveSession(newSession);
        storageService.chekAndCreateFolder();
        return new JwtResponse(jwt);
    }


    public ResponseEntity logout(HttpServletRequest request) {
        String authHeader = request.getHeader("auth-token");
        String newAuthHeader = authHeader.replace("Bearer ", "");
        sessionService.deleteSession(sessionService.getSessionByToken(newAuthHeader));
        return ResponseEntity.ok().body("Success logout");

    }

}
