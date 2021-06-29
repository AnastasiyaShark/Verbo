package com.shark.App.model.SwedishParticleVerb;

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
@Table(name = "swedish_prepositions")
public class SwedishPreposition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String preposition;
}
