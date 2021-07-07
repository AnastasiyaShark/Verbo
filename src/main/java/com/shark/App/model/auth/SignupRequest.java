package com.shark.App.model.auth;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.shark.App.model.user.Language;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class SignupRequest {

    private String name;
    private String email;
    private String password;
    private Language nativeLanguage;
    private Language learningLanguage;

    @JsonCreator
    public SignupRequest(@JsonProperty("name") String name,
                         @JsonProperty("email") String email,
                         @JsonProperty("password") String password,
                         @JsonProperty("nativeLanguage") Language nativeLanguage,
                         @JsonProperty("learningLanguage") Language learningLanguage) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.nativeLanguage = nativeLanguage;
        this.learningLanguage = learningLanguage;
    }
}
