package com.shark.App.model.User;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

//https://www.baeldung.com/intro-to-project-lombok#builder
@Builder
//EMPTY constructor generation
@NoArgsConstructor
//generates a constructor with 1 parameter for each field in your class. Fields marked with @NonNull result in null checks on those parameters.
@AllArgsConstructor
//generate Getter and Setter for all the fields of the class
@Getter
@Setter
// can add an access modifier (public, private, or protected) to each field in the annotated class or enum
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
//generate a toString() method including all class attributes
@ToString
//way to set a custom SQL table name
@Table(name = "users")
public class User {

    @Id
    //value will be automatically generated for that field (IDENTITY - generated values are unique)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String password;
    String email;
    //many users can have one language
    @ManyToOne
    Language nativeLanguage;
    @ManyToOne
    Language learningLanguage1;

    //Can user learn 2 languages?
    //Language learningLanguage2;
}


