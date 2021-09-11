package com.shark.App.service;

import com.shark.App.dto.UserDto;
import com.shark.App.exeption.ErrorInputData;
import com.shark.App.exeption.ErrorUnauthorized;
import com.shark.App.model.auth.Session;
import com.shark.App.model.auth.SigningRequest;
import com.shark.App.model.user.User;
import com.shark.App.repository.LanguageRepository;
import com.shark.App.repository.UserRepository;
import com.shark.App.security.JwtAuthTokenFilter;
import com.shark.App.security.JwtProvider;
import com.shark.App.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
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
    private final LanguageRepository languageRepository;

    private final ConversionService conversionService;


    public String authenticateUser(SigningRequest loginRequest) {
        //конвертирует user'a
        System.out.printf("Login (%s) Password (%s)", loginRequest.getEmail(), loginRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //получаем токен
        String jwt = jwtProvider.generateJwtToken(authentication);
        Session newSession = new Session(loginRequest.getEmail(), jwt);
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
        if (sessionService.checkSessionRepository(session) || session.getToken() == null) {
            throw new ErrorUnauthorized("Невозможно выйти! Сессия c данным токеном не существует.");
        }
        sessionService.deleteSession(session);
        return ResponseEntity.ok().body("Success logout");


    }


    public UserDto registerUser(UserDto userDto) {
        UserDto checkUserDto = checkUserDto(userDto);
        if (checkUserDto.getName() == null || checkUserDto.getPassword() == null ||
                checkUserDto.getNativeLanguageId() == null || checkUserDto.getLearningLanguage1Id() == null) {
            return checkUserDto;
        }
        // Create new user's account
        User newUser = conversionService.convert(userDto, User.class);
        assert newUser != null;
        newUser.setPassword(encoder.encode(newUser.getPassword()));
        newUser = userRepository.save(newUser);
//        ResponseEntity.ok().body("User registered successfully!")
        return conversionService.convert(newUser, UserDto.class);
    }

    public UserDto checkUserDto(UserDto userDto) {
        if (userRepository.existsByName(userDto.getName())) {
            userDto.setName(null);
//            throw new ErrorInputData(String.format("Error: Name %s is already taken!", userDto.getName()));
        }
        if (userDto.getPassword().length() < 4) {
            userDto.setPassword(null);
//            throw new ErrorInputData("Error: Password must be min 4 taken!");
        }
        if (userDto.getNativeLanguageId().equals(userDto.getLearningLanguage1Id())) {
            userDto.setNativeLanguageId(null);
            userDto.setLearningLanguage1Id(null);
//            throw new ErrorInputData("Error: Родной и изучаемый языки не могут быть одинаковые!");
        }
        return userDto;
    }


}
