package com.vitek.javalabs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Director {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
