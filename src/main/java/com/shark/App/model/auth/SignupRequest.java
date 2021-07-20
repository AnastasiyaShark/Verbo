package com.shark.App.model.auth;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.shark.App.exeption.ErrorInputData;


import com.shark.App.model.user.LanguageE;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequest {

    private String name;
    private String password;
    private String email;
    private LanguageE nativeLanguage;
    private LanguageE learningLanguage1;

    @JsonCreator
    public SignupRequest(@JsonProperty("name")String name,
                         @JsonProperty("password")String password,
                         @JsonProperty("email")String email,
                         @JsonProperty("nativeLanguage")String nativeLanguage,
                         @JsonProperty("learningLanguage")String learningLanguage1) {
        this.name = name;
        this.password = password;
        this.email = email;
        if (checkLanguage(nativeLanguage)){
            this.nativeLanguage = LanguageE.valueOf(nativeLanguage);
        }
        if (checkLanguage(learningLanguage1)){
            this.learningLanguage1 = LanguageE.valueOf(learningLanguage1);
        }

    }

    public boolean checkLanguage (String language){
        if (isEmpty(language)){
           throw new ErrorInputData("Обязательное поле для заполнения!");
        }
        if (!language.equals(LanguageE.ENGLISH.getLanguage()) &&
                !language.equals(LanguageE.SWEDISH.getLanguage()) &&
                !language.equals(LanguageE.RUSSIAN.getLanguage())){
            throw new ErrorInputData("Неверное значение языка");
        }
        return true;
    }

    public boolean isEmpty(String language) {
        return language == null;
    }
}
