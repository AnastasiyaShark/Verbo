package com.shark.App.model.englishVerb;

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
@Table(name = "english_verbs_translation")
public class EnglishVerbsTranslation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @ManyToOne
    EnglishVerb englishVerb;
    @ManyToOne
    SwedishVerb swedishVerb;
    @ManyToOne
    RussianVerb russianVerb;
    @ManyToOne
    SwedishParticleVerb swedishParticleVerb;
}
