package com.shark.App.model.auth;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SigningRequest {
    private String login;
    private String password;


    @JsonCreator
    public SigningRequest(@JsonProperty("login") String login,
                          @JsonProperty("password") String password) {
        this.login = login;
        this.password = password;
    }

}
