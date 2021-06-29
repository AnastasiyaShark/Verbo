package com.shark.App.model.EnglishVerb;

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
@Table(name = "english_verbs")
public class EnglishVerb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String infinitive;
    String presentTense;
    String past;
    String pastParticiple;
    Boolean returnability;
    Boolean regular;
    //one english verb can have one picture
    @OneToOne
    Picture picture;
}
