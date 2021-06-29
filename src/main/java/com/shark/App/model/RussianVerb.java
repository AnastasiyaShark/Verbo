package com.shark.App.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@ToString
@Table(name = "russian_verbs")
public class RussianVerb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String presens;
    @OneToOne
    Picture picture;
}
