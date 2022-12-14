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
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;
    private String title;
    private String description;

    @OneToMany(mappedBy = "projet")
    List<Sprint> sprintList;

    @ManyToMany(mappedBy = "projectList")
    List<User> userList;
}

