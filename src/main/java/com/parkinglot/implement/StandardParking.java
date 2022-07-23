package com.parkinglot.implement;

import com.parkinglot.entity.Car;
import com.parkinglot.entity.ParkingLot;
import com.parkinglot.entity.ParkingTicket;
import com.parkinglot.exception.WithoutAnyPositionException;
import com.parkinglot.interfaces.ParkCarStrategy;

import java.util.List;

public class StandardParking implements ParkCarStrategy {

    @Override
    public ParkingTicket park(Car car, List<ParkingLot> parkingLots) {
        ParkingLot parkingLot = parkingLots.stream()
                .filter(oneParkingLot -> oneParkingLot.getPositionNumber() > 0)
                .findFirst().orElse(null);
        if (parkingLot != null) {
            return parkingLot.park(car);
        } else {
            throw new WithoutAnyPositionException();
        }
    }
}
