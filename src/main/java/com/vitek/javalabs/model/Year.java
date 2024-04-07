package com.vitek.javalabs.model;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Year {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String yearRel;
}
