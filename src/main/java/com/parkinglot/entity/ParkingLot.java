package com.parkinglot.entity;

import com.parkinglot.exception.UnrecognizedParkingTicketException;
import com.parkinglot.exception.WithoutAnyPositionException;

import java.util.HashMap;
import java.util.Map;
public class ParkingLot {
    private final Map<ParkingTicket, Car> parkingTicketCarMap = new HashMap<>();
    private int positionNumber;

    public ParkingLot(int positionNumber) {
        this.positionNumber = positionNumber;
    }

    public ParkingTicket park(Car car) {
        if (getCapacity() > 0) {
            ParkingTicket parkingTicket = new ParkingTicket();
            parkingTicketCarMap.put(parkingTicket, car);
            return parkingTicket;
        } else {
            throw new WithoutAnyPositionException();
        }
    }


    public Car fetchCarByParkingTicket(ParkingTicket parkingTicket) {
        if (parkingTicketCarMap.containsKey(parkingTicket)) {
            return parkingTicketCarMap.remove(parkingTicket);
        } else {
            throw new UnrecognizedParkingTicketException();
        }
    }

    public int getCapacity() {
        return positionNumber - parkingTicketCarMap.size();
    }
    public Double getRate() {
        if(positionNumber == 0){
            return 0.0;
        }
        return (getCapacity() * 1.0) / positionNumber ;
    }
}
