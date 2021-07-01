package com.shark.App.model.englishParticleVerb;

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
@Table(name = "english_prepositions")
public class EnglishPreposition {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Integer id;
        String preposition;
}
