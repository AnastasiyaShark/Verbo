package com.shark.App.model.SwedishVerb;

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
@Table(name = "swedish_verbs_translation")
public class SwedishVerbsTranslation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    SwedishVerb swedishVerb;
    @ManyToOne
    EnglishVerb englishVerb;
    @ManyToOne
    RussianVerb russianVerb;
    @ManyToOne
    EnglishParticleVerb englishParticleVerb;


}
