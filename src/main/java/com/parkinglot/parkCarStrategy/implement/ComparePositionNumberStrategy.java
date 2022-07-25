package com.parkinglot.parkCarStrategy.implement;

import com.parkinglot.entity.Car;
import com.parkinglot.entity.ParkingLot;
import com.parkinglot.entity.ParkingTicket;
import com.parkinglot.exception.WithoutAnyPositionException;
import com.parkinglot.parkCarStrategy.interfaces.ParkCarStrategy;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ComparePositionNumberStrategy implements ParkCarStrategy {

    @Override
    public ParkingTicket park(Car car, List<ParkingLot> parkingLots, Map<ParkingTicket,ParkingLot> parkingTicketParkingLotMap) {
        ParkingLot parkingLot = parkingLots.stream()
                .sorted(Comparator.comparing(ParkingLot::getCapacity).reversed())
                .collect(Collectors.toList())
                .get(0);
        if (parkingLot != null) {
            ParkingTicket parkingTicket = parkingLot.park(car);
            parkingTicketParkingLotMap.put(parkingTicket,parkingLot);
            return parkingTicket;
        } else {
            throw new WithoutAnyPositionException();
        }
    }
}
