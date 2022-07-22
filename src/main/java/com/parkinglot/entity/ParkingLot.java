package com.parkinglot.entity;

public class ParkingLot {

    public ParkingTicket park(Car car){

        return new ParkingTicket();
    }
    public Car fetchCarByParkingTicket(ParkingTicket parkingTicket){
        return new Car();
    }
}
