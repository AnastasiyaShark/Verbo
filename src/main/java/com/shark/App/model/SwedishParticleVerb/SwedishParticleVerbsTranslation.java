package com.shark.App.model.SwedishParticleVerb;

import com.shark.App.model.EnglishParticleVerb.EnglishParticleVerb;
import com.shark.App.model.EnglishVerb.EnglishVerb;
import com.shark.App.model.RussianVerb;
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
@Table(name = "swedish_particle_verbs_translation")
public class SwedishParticleVerbsTranslation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @ManyToOne
    SwedishParticleVerb swedishParticleVerb;
    @ManyToOne
    EnglishVerb englishVerb;
    @ManyToOne
    RussianVerb russianVerb;
    @ManyToOne
    EnglishParticleVerb englishParticleVerb;
}
