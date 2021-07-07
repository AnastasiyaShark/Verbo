package com.shark.App.dto;

import com.shark.App.model.user.Language;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor//generates a constructor with 1 parameter for each field in your class
@NoArgsConstructor
public class UserDto {

    private Integer id;
    private String name;
    private String password;
    private String email;
    private Language nativeLanguage;
    private Language learningLanguage1;
}
