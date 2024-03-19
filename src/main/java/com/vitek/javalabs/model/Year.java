package com.vitek.javalabs.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
