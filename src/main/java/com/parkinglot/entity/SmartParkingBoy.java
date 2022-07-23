package com.parkinglot.entity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SmartParkingBoy extends StandardParkingBoy {

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingTicket park(Car car) {
        ParkingLot parkingLot = super.getParkingLots().stream()
                .sorted(Comparator.comparing(ParkingLot::getPositionNumber).reversed())
                .collect(Collectors.toList())
                .get(0);
        if (parkingLot != null) {
            return parkingLot.park(car);
        } else {
            throw new WithoutAnyPositionException();
        }
    }


}
