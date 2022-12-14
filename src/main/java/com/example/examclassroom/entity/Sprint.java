package com.example.examclassroom.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sprint implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @ManyToOne(cascade = CascadeType.PERSIST)
    Project projet;
}
