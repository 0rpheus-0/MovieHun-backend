package com.vitek.javalabs.model;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Actor {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
