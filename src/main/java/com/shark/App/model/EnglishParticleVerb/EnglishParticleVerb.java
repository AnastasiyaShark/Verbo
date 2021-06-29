package com.shark.App.model.EnglishParticleVerb;

import com.shark.App.model.EnglishVerb.EnglishVerb;
import com.shark.App.model.Picture;
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
@Table(name = "english_particle_verbs")
public class EnglishParticleVerb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @OneToOne
    EnglishVerb verb;
    @ManyToOne
    EnglishPreposition firstPreposition;
    @ManyToOne
    EnglishPreposition secondPreposition;
    @OneToOne
    Picture picture;
}
