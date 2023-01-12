package com.example.fedel.restapi.racket;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Racket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 60, nullable = false)
    private String name;

    @Column(length = 1020, nullable = false)
    private String description;

    @Column(length = 90, nullable = true)
    private String image;

    private int strungWeight;
    private float balance;
    private float length;
    private int headSize;

    @Column(length = 5, nullable = false)
    private String stringPattern;

    @Column(length = 8, nullable = false)
    private String beamWidth;

    private int stiffness;
    private float price;
}
