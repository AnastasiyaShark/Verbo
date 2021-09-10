package com.shark.App.model.auth;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SigningRequest {
    private String email;
    private String password;


    @JsonCreator
    public SigningRequest(@JsonProperty("email") String email,
                          @JsonProperty("password") String password) {
        this.email = email;
        this.password = password;
    }

}
