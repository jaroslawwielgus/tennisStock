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
    private String description;
    private String image;
    private int strungWeight;
    private float length;
    private int headSize;
    private String stringPattern;
    private String beamWidth;
    private int stiffness;
    private float price;
}
