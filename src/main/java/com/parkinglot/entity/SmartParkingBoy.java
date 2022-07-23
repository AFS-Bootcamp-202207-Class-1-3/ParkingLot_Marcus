package com.parkinglot.entity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends StandardParkingBoy {

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingTicket park(Car car) {
        ParkingLot parkingLot = super.getParkingLots().stream()
                .filter(oneParkingLot -> oneParkingLot.getPositionNumber() > 0)
                .sorted(Comparator.comparing(ParkingLot::getPositionNumber).reversed())
                .findFirst().orElse(null);
        if (parkingLot != null) {
            return parkingLot.park(car);
        } else {
            throw new WithoutAnyPositionException();
        }
    }


}
