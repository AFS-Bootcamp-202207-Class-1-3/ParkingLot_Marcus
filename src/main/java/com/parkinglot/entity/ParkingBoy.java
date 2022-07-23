package com.parkinglot.entity;

public class ParkingBoy implements ParkCar, FetchCar {
    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    @Override
    public ParkingTicket park(Car car) {
        return parkingLot.park(car);
    }

    @Override
    public Car fetch(ParkingTicket parkingTicket) {
        return parkingLot.fetchCarByParkingTicket(parkingTicket);
    }
}
