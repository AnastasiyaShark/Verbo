package com.shark.App.model.swedishParticleVerb;

import com.shark.App.model.Picture;
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
@Table(name = "swedish_particle_verbs")
public class SwedishParticleVerb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @OneToOne
    SwedishVerb verb;
    //many swedish particle verbs can have one preposition
    @ManyToOne
    SwedishPreposition firstPreposition;
    @ManyToOne
    SwedishPreposition secondPreposition;
    @OneToOne
    Picture picture;

}
