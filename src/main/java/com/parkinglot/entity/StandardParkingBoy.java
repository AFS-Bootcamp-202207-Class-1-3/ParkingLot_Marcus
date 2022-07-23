package com.parkinglot.entity;

import java.util.ArrayList;
import java.util.List;

public class StandardParkingBoy {
    private List<ParkingLot> parkingLots = new ArrayList<>();

    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkingTicket park(Car car) {
        return parkingLots.get(0).park(car);
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }
}
