package com.vitek.javalabs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Year {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String yearRel;
}
