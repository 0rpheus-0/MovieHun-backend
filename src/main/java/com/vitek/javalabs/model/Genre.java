package com.vitek.javalabs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Genre {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
