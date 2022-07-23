package com.parkinglot.implement;

import com.parkinglot.entity.Car;
import com.parkinglot.entity.ParkingLot;
import com.parkinglot.entity.ParkingTicket;
import com.parkinglot.exception.WithoutAnyPositionException;
import com.parkinglot.interfaces.ParkCarStrategy;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SmartParking implements ParkCarStrategy {

    @Override
    public ParkingTicket park(Car car, List<ParkingLot> parkingLots) {
        ParkingLot parkingLot = parkingLots.stream()
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
