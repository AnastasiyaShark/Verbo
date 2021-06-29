package com.shark.App.model;

import com.shark.App.model.EnglishParticleVerb.EnglishParticleVerb;
import com.shark.App.model.EnglishVerb.EnglishVerb;
import com.shark.App.model.SwedishParticleVerb.SwedishParticleVerb;
import com.shark.App.model.SwedishVerb.SwedishVerb;
import com.shark.App.model.User.User;
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
