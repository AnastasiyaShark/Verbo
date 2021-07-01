package com.shark.App.model.vocabulary;

import com.shark.App.model.englishParticleVerb.EnglishParticleVerb;
import com.shark.App.model.englishVerb.EnglishVerb;
import com.shark.App.model.swedishParticleVerb.SwedishParticleVerb;
import com.shark.App.model.swedishVerb.SwedishVerb;
import com.shark.App.model.user.User;
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
@Table(name = "vocabularies")
public class Vocabulary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @OneToOne
    User user;
    //many vocabulary can have one swedish verb
    @ManyToOne
    SwedishVerb swedishVerb;
    @ManyToOne
    SwedishParticleVerb swedishParticleVerb;
    @ManyToOne
    EnglishVerb englishVerb;
    @ManyToOne
    EnglishParticleVerb englishParticleVerb;
    //many word can have one status
    @ManyToOne
    VerbsStatus status;

}
