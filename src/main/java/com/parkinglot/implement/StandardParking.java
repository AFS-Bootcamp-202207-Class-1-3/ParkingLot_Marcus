package com.parkinglot.implement;

import com.parkinglot.entity.Car;
import com.parkinglot.entity.ParkingLot;
import com.parkinglot.entity.ParkingTicket;
import com.parkinglot.exception.WithoutAnyPositionException;
import com.parkinglot.interfaces.ParkCarStrategy;

import java.util.List;
import java.util.Map;

public class StandardParking implements ParkCarStrategy {

    @Override
    public ParkingTicket park(Car car, List<ParkingLot> parkingLots, Map<ParkingTicket,ParkingLot> parkingTicketParkingLotMap) {
        ParkingLot parkingLot = parkingLots.stream()
                .filter(oneParkingLot -> oneParkingLot.getPositionNumber() > 0)
                .findFirst().orElse(null);
        if (parkingLot != null) {
            ParkingTicket parkingTicket = parkingLot.park(car);
            parkingTicketParkingLotMap.put(parkingTicket,parkingLot);
            return parkingTicket;
        } else {
            throw new WithoutAnyPositionException();
        }
    }
}
