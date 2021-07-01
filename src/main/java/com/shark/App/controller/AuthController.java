package com.shark.App.controller;

import com.shark.App.model.auth.JwtResponse;
import com.shark.App.model.auth.LoginForm;
import com.shark.App.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestController
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public JwtResponse authenticateUser(@RequestBody LoginForm loginRequest) {
        return authService.authenticateUser(loginRequest);
    }


    @PostMapping("/logout")
    public ResponseEntity logout(HttpServletRequest request) {
        return authService.logout(request);

    }
}
