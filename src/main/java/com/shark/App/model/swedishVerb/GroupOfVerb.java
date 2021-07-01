package com.shark.App.model.swedishVerb;

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
@Table(name = "group_swedish_verbs")
public class GroupOfVerb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Group name;

}
