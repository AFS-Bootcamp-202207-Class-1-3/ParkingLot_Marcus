package com.parkinglot.entity;

import java.util.Objects;

public class Car {
    private String numberPlate;

    public Car(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return numberPlate.equals(car.numberPlate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberPlate);
    }
}
