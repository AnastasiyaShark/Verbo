package com.shark.App.service;

import com.shark.App.dto.UserDto;
import com.shark.App.exeption.ErrorInputData;
import com.shark.App.exeption.ErrorUnauthorized;
import com.shark.App.model.auth.SigningRequest;
import com.shark.App.model.auth.Session;
import com.shark.App.repository.UserRepository;
import com.shark.App.security.JwtAuthTokenFilter;
import com.shark.App.security.JwtProvider;
import com.shark.App.service.user.UserService;
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

    private final SessionService sessionService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final JwtProvider jwtProvider;
    private final JwtAuthTokenFilter jwtAuthTokenFilter;
    private final UserService userService;


    public String authenticateUser(SigningRequest loginRequest) {
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
            throw new ErrorInputData("Невозможно войти! Сессия c данным токеном уже существует. Please, try again!");
        }
        //сохраняем сессию
        sessionService.saveSession(newSession);
        System.out.println(sessionService.getAll());
        return newSession.getToken();
    }


    public ResponseEntity logout(HttpServletRequest request) {

        String authHeader = request.getHeader("auth-token");
        String newAuthHeader = authHeader.replace("Bearer ", "");
        Session session = sessionService.getSessionByToken(newAuthHeader);
        if (sessionService.checkSessionRepository(session) || session.getToken() == null){
            throw new ErrorUnauthorized("Невозможно выйти! Сессия c данным токеном не существует.");
        }
        sessionService.deleteSession(session);
        return ResponseEntity.ok().body("Success logout");


    }


    public ResponseEntity registerUser(UserDto userDto) { //signUpRequest
        if (userRepository.existsByName(userDto.getName())) {
            throw new ErrorInputData(String.format("Error: Name %s is already taken!",userDto.getName()));
        }
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new ErrorInputData(String.format("Error: Email %s is already in use!",userDto.getEmail()));
        }
        if (userDto.getNativeLanguage().equals(userDto.getLearningLanguage1())){
            throw new ErrorInputData("Error: Родной и изучаемый языки не могут быть одинаковые!");
        }
        // Create new user's account
        userService.createUser(userDto);
        return ResponseEntity.ok().body("User registered successfully!");
    }



}
