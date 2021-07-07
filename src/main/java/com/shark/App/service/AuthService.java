package com.shark.App.service;

import com.shark.App.dto.UserDto;
import com.shark.App.exeption.ErrorInputData;
import com.shark.App.model.auth.JwtResponse;
import com.shark.App.model.auth.SigningRequest;
import com.shark.App.model.auth.Session;
import com.shark.App.model.auth.SignupRequest;
import com.shark.App.model.user.User;
import com.shark.App.repository.UserRepository;
import com.shark.App.security.JwtAuthTokenFilter;
import com.shark.App.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

@Component
@Service
@RequiredArgsConstructor
public class AuthService {

    private final SessionService sessionService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final JwtProvider jwtProvider;
    private final JwtAuthTokenFilter jwtAuthTokenFilter;
    private final ConversionServiceFactoryBean factoryBean;

    public JwtResponse authenticateUser(SigningRequest loginRequest) {
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

        //проверяем,есть ли уже такая сессия (token)
        if (!sessionService.checkSessionRepository(newSession)) {
            throw new ErrorInputData("Невозможно войти! Сессия c данным токеном уже существует");
        }
        //сохраняем сессию
        sessionService.saveSession(newSession);
        return new JwtResponse(jwt);
    }


    public ResponseEntity logout(HttpServletRequest request) {
        String authHeader = request.getHeader("auth-token");
        String newAuthHeader = authHeader.replace("Bearer ", "");
        sessionService.deleteSession(sessionService.getSessionByToken(newAuthHeader));
        return ResponseEntity.ok().body("Success logout");
    }


    public ResponseEntity registerUser(UserDto userDto) { //signUpRequest
        if (userRepository.existsByName(userDto.getName())) {
            return ResponseEntity
                    .badRequest()
                    .body(String.format("Error: Name %s is already taken!",userDto.getName()));
        }

        if (userRepository.existsByEmail(userDto.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(String.format("Error: Email %s is already in use!",userDto.getEmail()));
        }

        // Create new user's account
        User user = factoryBean.getObject().convert(userDto, User.class);
        userRepository.save (user);
        return ResponseEntity.ok("User registered successfully!");
    }



}
