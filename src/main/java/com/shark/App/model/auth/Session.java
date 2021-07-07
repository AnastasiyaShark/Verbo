package com.shark.App.model.auth;

import lombok.*;


@Getter
@Setter
@ToString
public class Session {
    String email;
    String token;

    public Session(String email, String token) {
        this.email = email;
        this.token = token;
    }
}
