package com.example.fedel.restapi.racketString;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class RacketString {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 60, nullable = false)
    private String name;

    @Column(length = 1020, nullable = false)
    private String description;

    @Column(length = 90, nullable = true)
    private String image;

    enum Type {
        HYBRYDOWY,
        NATURALNY,
        POLIESTROWY,
        SYNTETYCZNY,
        WIELOWŁÓKNISTY
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false)
    private Type type;

    private float diameter;
    private float length;

    enum Color {
        CZARNY,
        NIEBIESKI,
        BRĄZOWY,
        BEŻOWY,
        BIAŁY,
        ZŁOTY,
        ZIELONY,
        SZARY,
        POMARAŃCZOWY,
        RÓŻOWY,
        FIOLETOWY,
        CZERWONY,
        SREBRNY,
        ŻÓŁTY,
        NATURALNY,
        LIMONKOWY,
        BURSZTYNOWY,
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false)
    private Color color;

    private float price;
}
