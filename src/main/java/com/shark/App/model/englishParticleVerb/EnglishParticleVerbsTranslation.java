package com.shark.App.model.englishParticleVerb;

import com.shark.App.model.RussianVerb;
import com.shark.App.model.swedishParticleVerb.SwedishParticleVerb;
import com.shark.App.model.swedishVerb.SwedishVerb;
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
@Table(name = "english_particle_verbs_translation")
public class EnglishParticleVerbsTranslation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @ManyToOne
    EnglishParticleVerb englishParticleVerb;
    @ManyToOne
    SwedishVerb swedishVerb;
    @ManyToOne
    RussianVerb russianVerb;
    @ManyToOne
    SwedishParticleVerb swedishParticleVerb;
}
