package com.example.fedel.restapi.ball;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Ball {
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String description;
    private String surface;
    private String ballType;
    private String ballClass;
    private int quantity;
    private float price;
}
