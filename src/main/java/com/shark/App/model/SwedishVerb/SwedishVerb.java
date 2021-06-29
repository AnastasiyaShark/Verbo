package com.shark.App.model.SwedishVerb;

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
@Table(name = "swedish_verbs")
public class SwedishVerb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String imperative;
    String infinitive;
    String presens;
    String preteritum;
    String supinum;
    //many swedish verbs can have one group
    @ManyToOne
    GroupOfVerb groupOfVerb;
    Boolean returnability;
    Boolean regular;
    //one swedish verb can have one picture
    @OneToOne
    Picture picture;




}
