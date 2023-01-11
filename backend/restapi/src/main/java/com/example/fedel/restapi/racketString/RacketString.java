package com.example.fedel.restapi.racketString;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class RacketString {
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String description;
    private String image;
    private String type;
    private float diameter;
    private float length;
    private String color;
    private float price;
}
