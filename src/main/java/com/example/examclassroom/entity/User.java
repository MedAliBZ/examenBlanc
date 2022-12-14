package com.example.examclassroom.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;
    private String email;
    private String pwd;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToMany
    List<Project> projectList;

    @OneToMany
    List<Project> projects;

}
