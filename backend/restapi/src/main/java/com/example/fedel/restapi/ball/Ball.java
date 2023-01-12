package com.example.fedel.restapi.ball;

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
public class Ball {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 60, nullable = false)
    private String name;

    @Column(length = 1020, nullable = false)
    private String description;

    @Column(length = 90, nullable = true)
    private String image;

    enum Surface {
        CEGLANA,
        WSZYSTKIE
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false)
    private Surface surface;

    enum BallType {
        CIŚNIENIOWA,
        BEZCIŚNIENIOWA,
        STAGE1,
        STAGE2,
        STAGE3,
        GĄBCZASTA
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false)
    private BallType ballType;

    enum BallClass {
        PREMIUM,
        STANDARD
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false)
    private BallClass ballClass;

    private int quantity;

    private float price;

    // public int getId() {
    // return this.id;
    // }

    // public void setId(int id) {
    // this.id = id;
    // }

    // public String getName() {
    // return this.name;
    // }

    // public void setName(String name) {
    // this.name = name;
    // }

    // public String getDescription() {
    // return this.description;
    // }

    // public void setDescription(String description) {
    // this.description = description;
    // }

    // public String getImage() {
    // return this.image;
    // }

    // public void setImage(String image) {
    // this.image = image;
    // }

    // public String getSurface() {
    // return this.surface;
    // }

    // public void setSurface(String surface) {
    // this.surface = surface;
    // }

    // public String getBallType() {
    // return this.ballType;
    // }

    // public void setBallType(String ballType) {
    // this.ballType = ballType;
    // }

    // public String getBallClass() {
    // return this.ballClass;
    // }

    // public void setBallClass(String ballClass) {
    // this.ballClass = ballClass;
    // }

    // public int getQuantity() {
    // return this.quantity;
    // }

    // public void setQuantity(int quantity) {
    // this.quantity = quantity;
    // }

    // public float getPrice() {
    // return this.price;
    // }

    // public void setPrice(float price) {
    // this.price = price;
    // }
}
