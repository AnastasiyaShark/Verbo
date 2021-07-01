package com.shark.App.model.auth;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtResponse {

    @JsonProperty("auth-token")
    private String token;

    @JsonCreator
    public JwtResponse(@JsonProperty("auth-token") String accessToken) {
        this.token = accessToken;
    }
}
