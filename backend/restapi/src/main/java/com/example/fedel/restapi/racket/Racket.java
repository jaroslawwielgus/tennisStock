package com.example.fedel.restapi.racket;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Racket {
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private int weight;
    private String stringPattern;
    private int stiffness;
    private int price;
}
