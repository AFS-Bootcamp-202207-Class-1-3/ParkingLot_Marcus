package com.parkinglot.entity;

public class ParkingTicket {
    private Car car;

    public ParkingTicket(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }
}
